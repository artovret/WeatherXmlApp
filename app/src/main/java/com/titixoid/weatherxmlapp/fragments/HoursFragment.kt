package com.titixoid.weatherxmlapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.titixoid.weatherxmlapp.MainViewModel
import com.titixoid.weatherxmlapp.R
import com.titixoid.weatherxmlapp.adapters.WeatherAdapter
import com.titixoid.weatherxmlapp.adapters.WeatherModel
import com.titixoid.weatherxmlapp.databinding.FragmentHoursBinding


class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        model.liveDataList.observe(viewLifecycleOwner) {
            model.liveDataCurrent.observe(viewLifecycleOwner){
                val maxMinTemp = "${it.maxTemp}C°/${it.minTemp}"
                tvData.text = it.time
                tvCity.text = it.city
                tvCurrentTemp.text = it.currentTemp
                tvCondition.text = it.condition
                tvMaxMin.text = maxMinTemp
                Picasso.get().load("https:" + it.imageUrl).into(imWeather)
            }
        }
    }

    private fun initRcView() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel("","12:00","Sunny", "23°","13°","25°", "", ""),
            WeatherModel("","13:00","Sunny", "24°","13°","25°", "", ""),
            WeatherModel("","14:00","Sunny", "25°","13°","25°", "", ""),
            WeatherModel("","15:00","Sunny", "23°","13°","25°", "", "")
        )
        adapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() =   HoursFragment()
    }
}