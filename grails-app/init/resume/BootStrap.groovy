package resume

class BootStrap {

    def init = { servletContext ->
        createSaveAccount("Alba",  "Miranda")
    }

    def destroy = {
    }

    def createSaveAccount(name, password){
        def account = new UserAccount(userName : name, password : password).save()
        def profile = new Profile(ownerAccount : account.getId()).save()
    }
}
