package resume

class Qualification {

    static belongsTo = [userProfile : Profile]
    static hasOne = [date : String, workPlace : String, jobTitle: String, jobDescription : String]

    static constraints = {
    }
}
