package br.com.david.inelviskotlinstudy.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.david.inelviskotlinstudy.R
import br.com.david.inelviskotlinstudy.domain.Car

class CarAdapter(
        private val context: Context,
        private val cars: List<Car>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(cars[position])
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage: ImageView
        var ivLogo: ImageView
        var tvModel: TextView
        var tvBrand: TextView
        var tvMotor: TextView
        var tvAccessories: TextView
        var tvPrice: TextView

        init {
            ivImage = itemView.findViewById(R.id.iv_image)
            ivLogo = itemView.findViewById(R.id.iv_logo)
            tvModel = itemView.findViewById(R.id.tv_model)
            tvBrand = itemView.findViewById(R.id.tv_brand)
            tvMotor = itemView.findViewById(R.id.tv_motor)
            tvAccessories = itemView.findViewById(R.id.tv_accessories)
            tvPrice = itemView.findViewById(R.id.tv_price)
        }

        fun setData(car: Car) {
            ivImage.setImageBitmap(car.image)
            tvModel.text = car.model
            ivLogo.setImageResource(car.brand.logo)
            val brandStr = "${car.brand.name} - ${car.year}"
            tvBrand.text = brandStr
            val motorStr = "Motor: ${car.motor.model} (${car.motor.cylinders}) - ${car.motor.brand}"
            tvMotor.text = motorStr
            val accessoriesStr = "Acessórios: ${car.getAccessoriesFormatted()}"
            tvAccessories.text = accessoriesStr
            tvPrice.text = car.price.toString()
        }
    }
}