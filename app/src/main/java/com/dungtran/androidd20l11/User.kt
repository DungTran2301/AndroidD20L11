import java.io.Serializable

data class User(
    var name: String = "Ngoc Thuy",
    var phoneNumber: String = "Your phone number",
    var email: String = "Your email"
) : Serializable