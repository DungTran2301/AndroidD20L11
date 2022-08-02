package com.dungtran.androidd20l11.data

import java.io.Serializable

data class User(
    var name: String = "Lê Quang Dũng",
    var phoneNumber: String = "0824910986",
    var gmail: String = "sankatana02@gmail.com"
) : Serializable