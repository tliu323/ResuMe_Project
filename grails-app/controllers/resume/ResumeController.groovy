package resume

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional
import grails.rest.RestfulController

class ResumeController extends RestfulController {

    ResumeController(){
        super(Resume)
    }
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Resume.list(params), model:[resumeCount: Resume.count()]
    }

    def show(Resume resume) {
        respond resume
    }

    def create() {
        respond new Resume(params)
    }

    def save(Resume resume) {
        if (resume == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (resume.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond resume.errors, view:'create'
            return
        }

        resume.save flush:true

        request.withFormat {
            form multipartForm {
                //flash.message = message(code: 'default.created.message', args: [message(code: 'resume.label', default: 'Resume'), resume.id])
                redirect resume
            }
            '*' { respond resume, [status: CREATED] }
        }
    }

    def edit(Resume resume) {
        respond resume
    }

    def update(Resume resume) {
        if (resume == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (resume.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond resume.errors, view:'edit'
            return
        }

        resume.save flush:true

        request.withFormat {
            form multipartForm {
                //flash.message = message(code: 'default.updated.message', args: [message(code: 'resume.label', default: 'Resume'), resume.id])
                redirect resume
            }
            '*'{ respond resume, [status: OK] }
        }
    }

    def delete(Resume resume) {

        if (resume == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        resume.delete flush:true

        request.withFormat {
            form multipartForm {
                //flash.message = message(code: 'default.deleted.message', args: [message(code: 'resume.label', default: 'Resume'), resume.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
               // flash.message = message(code: 'default.not.found.message', args: [message(code: 'resume.label', default: 'Resume'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
