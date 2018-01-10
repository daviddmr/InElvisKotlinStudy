package br.com.david.inelviskotlinstudy.domain

import android.os.Parcel
import android.os.Parcelable

class Motor(
        val model: String,
        val cylinders: Int,
        val brand: String) : Parcelable {
    
    constructor(source: Parcel) : this(
            source.readString(),
            source.readInt(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(model)
        writeInt(cylinders)
        writeString(brand)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Motor> = object : Parcelable.Creator<Motor> {
            override fun createFromParcel(source: Parcel): Motor = Motor(source)
            override fun newArray(size: Int): Array<Motor?> = arrayOfNulls(size)
        }
    }
}