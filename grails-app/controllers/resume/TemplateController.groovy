package resume

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TemplateController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Template.list(params), model:[templateCount: Template.count()]
    }

    def show(Template template) {
        respond template
    }

    def create() {
        respond new Template(params)
    }

    @Transactional
    def save(Template template) {
        if (template == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (template.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond template.errors, view:'create'
            return
        }

        template.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'template.label', default: 'Template'), template.id])
                redirect template
            }
            '*' { respond template, [status: CREATED] }
        }
    }

    def edit(Template template) {
        respond template
    }

    @Transactional
    def update(Template template) {
        if (template == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (template.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond template.errors, view:'edit'
            return
        }

        template.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'template.label', default: 'Template'), template.id])
                redirect template
            }
            '*'{ respond template, [status: OK] }
        }
    }

    @Transactional
    def delete(Template template) {

        if (template == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        template.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'template.label', default: 'Template'), template.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'template.label', default: 'Template'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
