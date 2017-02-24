package resume

class Resume {

    Profile ownerProfile
    Template template

    static belongsTo = [ownerProfile : Profile]

    static hasOne = [template : Template]

    static constraints = {
    }
}
