package br.com.david.inelviskotlinstudy.data

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import br.com.david.inelviskotlinstudy.R
import br.com.david.inelviskotlinstudy.domain.Accessory
import br.com.david.inelviskotlinstudy.domain.Brand
import br.com.david.inelviskotlinstudy.domain.Car
import br.com.david.inelviskotlinstudy.domain.Motor
import java.util.*

class Mock {

    private fun generateMotor(): Motor {
        val models = arrayOf("V-Tec", "Rocan", "Zar-T")
        val cylinders = arrayOf(4, 4, 8)
        val brands = arrayOf("Volkswagen", "Ford", "GM")
        val randIndex = Random().nextInt(3)

        return Motor(models[randIndex], cylinders[randIndex], brands[randIndex])
    }

    private fun generateAccessoriesList(): List<Accessory> {
        val accessories = LinkedList<Accessory>()
        val randIndex = Random().nextInt(3) + 1

        while (accessories.size < randIndex) {
            val aux = generateAccessory()

            if (!inAccessories(aux, accessories)) {
                accessories.add(aux)
            }
        }

        return accessories
    }

    private fun generateAccessory(): Accessory {
        val names = arrayOf("Teto solar", "Multimídia", "Aro 21 (Sport)", "Bancos de couro")
        val prices = arrayOf(2500f, 5600f, 8000f, 980f)
        val randIndex = Random().nextInt(4)

        return Accessory(names[randIndex], prices[randIndex])
    }

    private fun inAccessories(accessory: Accessory, accessories: List<Accessory>): Boolean {
        for (aux in accessories)
            if (aux.name == accessory.name)
                return true
        return false
    }

    private fun generateBitmap(resources: Resources, imageRes: Int): Bitmap {
        return BitmapFactory.decodeResource(resources, imageRes)
    }

    fun generateCar(resources: Resources): List<Car> {

        return listOf(
                Car(
                        "Impala",
                        2014,
                        Brand("Chevrolet", R.drawable.chevrolet_logo),
                        generateMotor(),
                        89_997f,
                        generateAccessoriesList(),
                        generateBitmap(resources, R.drawable.chevrolet_impala)),
                Car(
                        "Evoque",
                        2017,
                        Brand("Land Rover", R.drawable.land_rover_logo),
                        generateMotor(),
                        228_500f,
                        generateAccessoriesList(),
                        generateBitmap(resources, R.drawable.land_rover_evoque)),
                Car(
                        "Toureg",
                        2017,
                        Brand("Volkswagen", R.drawable.volkswagen_logo),
                        generateMotor(),
                        327_793f,
                        generateAccessoriesList(),
                        generateBitmap(resources, R.drawable.volkswagen_toureg)),
                Car(
                        "Fusion",
                        2017,
                        Brand("Ford", R.drawable.ford_logo),
                        generateMotor(),
                        98_650f,
                        generateAccessoriesList(),
                        generateBitmap(resources, R.drawable.ford_fusion)),
                Car(
                        "Taurus",
                        2015,
                        Brand("Ford", R.drawable.ford_logo),
                        generateMotor(),
                        113_985f,
                        generateAccessoriesList(),
                        generateBitmap(resources, R.drawable.ford_taurus))
        )
    }

}
