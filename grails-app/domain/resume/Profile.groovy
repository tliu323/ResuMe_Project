package resume

class Profile {

    UserAccount ownerAccount

    static hasMany = [resumes : Resume,// does map take format [instance: class]
                    qualification: Qualification]

    static hasOne = [address : Address]

    static constraints = {
        resumes nullable: true // can have zero resumes on a profile
        qualification nullable: true
        address nullable: true
    }
}

