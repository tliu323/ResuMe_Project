package resume

class Address {

    static hasOne = [ownerProfile : Profile, apt : String, streetName : String, city : String, postalCode : String, country : String]

    static constraints = {
        apt nullable: true
        streetName nullable: true
        postalCode nullable: true
    }
}
