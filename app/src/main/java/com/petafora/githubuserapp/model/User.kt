package com.petafora.githubuserapp.model

import android.os.Parcel
import android.os.Parcelable

data class User(
    var nomor: Int = 0,
    var username: String = "",
    var nama: String = "",
    var avatar: Int = 0,
    var follower: String = "",
    var following: String = "",
    var repository: String = "",
    var location: String = "",
    var company: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(nomor)
        parcel.writeString(username)
        parcel.writeString(nama)
        parcel.writeInt(avatar)
        parcel.writeString(follower)
        parcel.writeString(following)
        parcel.writeString(repository)
        parcel.writeString(location)
        parcel.writeString(company)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}