package br.com.david.inelviskotlinstudy.domain

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import br.com.david.inelviskotlinstudy.getPriceHumam

class Car(
        val model: String,
        val year: Int,
        val brand: Brand,
        val motor: Motor,
        val price: Float,
        val accessories: List<Accessory>,
        val image: Bitmap) : Parcelable {

    fun getAccessoriesFormatted(): String {
        val accessoriesStr = StringBuilder()

        for (accessory in accessories) {
            accessoriesStr.append("${accessory.name} (${accessory.price.getPriceHumam()}), ")
        }

        //First remove all blank spaces on final of the string, then remove all commas (if exist) on final of the string
        return accessoriesStr.trimEnd().trimEnd(',').toString()
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readInt(),
            source.readParcelable<Brand>(Brand::class.java.classLoader),
            source.readParcelable<Motor>(Motor::class.java.classLoader),
            source.readFloat(),
            source.createTypedArrayList(Accessory.CREATOR),
            source.readParcelable<Bitmap>(Bitmap::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(model)
        writeInt(year)
        writeParcelable(brand, 0)
        writeParcelable(motor, 0)
        writeFloat(price)
        writeTypedList(accessories)
        writeParcelable(image, 0)
    }

    companion object {
        @JvmField
        val CARS = "cars"
        val CREATOR: Parcelable.Creator<Car> = object : Parcelable.Creator<Car> {
            override fun createFromParcel(source: Parcel): Car = Car(source)
            override fun newArray(size: Int): Array<Car?> = arrayOfNulls(size)
        }
    }
}