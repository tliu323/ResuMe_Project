package resume

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional
import grails.rest.RestfulController


class QualificationController extends RestfulController{

    QualificationController(){
        super(Qualification)
    }

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Qualification.list(params), model:[qualificationCount: Qualification.count()]
    }

    def show(Qualification qualification) {
        respond qualification
    }

    def create() {
        respond new Qualification(params)
    }

    def save(Qualification qualification) {
        if (qualification == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (qualification.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond qualification.errors, view:'create'
            return
        }

        qualification.save flush:true

        request.withFormat {
            form multipartForm {
               // flash.message = message(code: 'default.created.message', args: [message(code: 'qualification.label', default: 'Qualification'), qualification.id])
                redirect qualification
            }
            '*' { respond qualification, [status: CREATED] }
        }
    }

    def edit(Qualification qualification) {
        respond qualification
    }

    def update(Qualification qualification) {
        if (qualification == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (qualification.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond qualification.errors, view:'edit'
            return
        }

        qualification.save flush:true

        request.withFormat {
            form multipartForm {
                //flash.message = message(code: 'default.updated.message', args: [message(code: 'qualification.label', default: 'Qualification'), qualification.id])
                redirect qualification
            }
            '*'{ respond qualification, [status: OK] }
        }
    }


    def delete(Qualification qualification) {

        if (qualification == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        qualification.delete flush:true

        request.withFormat {
            form multipartForm {
               // flash.message = message(code: 'default.deleted.message', args: [message(code: 'qualification.label', default: 'Qualification'), qualification.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                //flash.message = message(code: 'default.not.found.message', args: [message(code: 'qualification.label', default: 'Qualification'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
