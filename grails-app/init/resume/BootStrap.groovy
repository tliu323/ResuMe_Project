package resume

class BootStrap {

    def init = { servletContext ->
        createSaveAccount("Alba Whittlemore", "Miranda")
    }

    def destroy = {
    }

    def createSaveAccount(name, password){
        def account = new UserAccount(userName : name, userPassword : password)
        def profile = new Profile(ownerAccount : account).save()
    }
}
