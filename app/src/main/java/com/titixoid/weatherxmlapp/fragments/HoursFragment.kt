package com.titixoid.weatherxmlapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.titixoid.weatherxmlapp.R
import com.titixoid.weatherxmlapp.adapters.WeatherAdapter
import com.titixoid.weatherxmlapp.adapters.WeatherModel
import com.titixoid.weatherxmlapp.databinding.FragmentHoursBinding


class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter

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