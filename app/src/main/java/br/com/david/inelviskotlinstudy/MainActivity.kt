package br.com.david.inelviskotlinstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import br.com.david.inelviskotlinstudy.adapter.CarAdapter
import br.com.david.inelviskotlinstudy.data.Mock
import br.com.david.inelviskotlinstudy.domain.Car
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val cars = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cars.addAll(Mock().generateCar(resources))
        initRecyclerView()
    }

    fun initRecyclerView() {
        rv_cars.setHasFixedSize(true)
        val mLinearLayoutManager = LinearLayoutManager(this)
        rv_cars.layoutManager = mLinearLayoutManager

        val divider = DividerItemDecoration(this, mLinearLayoutManager.orientation)
        rv_cars.addItemDecoration(divider)

        val carAdapter = CarAdapter(this, cars)
        rv_cars.adapter = carAdapter
    }
}
