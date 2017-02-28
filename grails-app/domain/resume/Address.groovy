package resume

class Address {

    static belongsTo = [userProfile : Profile]
    static hasOne = [apt : String, streetName : String, city : String, postalCode : String, country : String]

    static constraints = {
        apt nullable: true
        streetName nullable: true
        postalCode nullable: true
    }
}
