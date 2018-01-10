package br.com.david.inelviskotlinstudy.domain

import android.os.Parcel
import android.os.Parcelable

data class Accessory(
        val name: String,
        val price: Float) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString(),
            source.readFloat()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeFloat(price)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Accessory> = object : Parcelable.Creator<Accessory> {
            override fun createFromParcel(source: Parcel): Accessory = Accessory(source)
            override fun newArray(size: Int): Array<Accessory?> = arrayOfNulls(size)
        }
    }
}