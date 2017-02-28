package resume

class Resume {

    static hasOne = [template : Template]

    static belongsTo = [userProfile : Profile]

    static constraints = {
    }
}
