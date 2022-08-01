package com.dungtran.androidd20l11

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name: String, val phone: String, val email: String) : Parcelable
