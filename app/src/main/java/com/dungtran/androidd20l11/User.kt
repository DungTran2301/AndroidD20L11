import java.io.Serializable

data class User(
    var name: String ,
    var phoneNumber: String ,
    var email: String
) : Serializable