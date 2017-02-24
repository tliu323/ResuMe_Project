package resume

class Address {

    Profile ownerProfile
    String apt
    String streetName
    String city
    String postalCode
    String country


    static belongsTo = [ownerProfile : Profile]

    static constraints = {
        apt nullable: true
        streetName nullable: true
        postalCode nullable: true
    }
}
