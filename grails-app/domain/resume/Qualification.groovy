package resume

class Qualification {

    Profile ownerProfile
    String date
    String workPlace
    String jobTitle
    String jobDescription

    static belongsTo = [ownerProfile: Profile]

    static constraints = {
    }
}
