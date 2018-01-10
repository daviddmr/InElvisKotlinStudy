package br.com.david.inelviskotlinstudy.domain

import android.graphics.Bitmap

class Car(
        val model: String,
        val year: Int,
        val brand: Brand,
        val motor: Motor,
        val price: Float,
        val accessories: List<Accessory>,
        val image: Bitmap) {

    fun getAccessoriesFormatted(): String {
        val accessoriesStr = StringBuilder()

        for (accessory in accessories) {
            accessoriesStr.append("${accessory.name} (${accessory.price}), ")
        }

        //First remove all blank spaces on final of the string, then remove all commas (if exist) on final of the string
        return accessoriesStr.trimEnd().trimEnd(',').toString()
    }
}