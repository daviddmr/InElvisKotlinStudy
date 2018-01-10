package br.com.david.inelviskotlinstudy.domain

import android.os.Parcel
import android.os.Parcelable

class Brand(
        val name: String,
        val logo: Int) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeInt(logo)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Brand> = object : Parcelable.Creator<Brand> {
            override fun createFromParcel(source: Parcel): Brand = Brand(source)
            override fun newArray(size: Int): Array<Brand?> = arrayOfNulls(size)
        }
    }
}