package com.loococo.dustproject.ui

import android.os.Bundle
import com.loococo.dustproject.R
import com.loococo.dustproject.common.Constants
import com.loococo.dustproject.data.model.DustItem
import com.loococo.dustproject.data.rest.dust.DustRepository
import com.loococo.dustproject.databinding.ActivityMainBinding
import com.loococo.dustproject.ui.base.BaseActivity
import com.loococo.dustproject.ui.model.DustViewModel
import com.loococo.dustproject.util.ToastFactory

class MainActivity : BaseActivity() {

    private lateinit var stationViewModel: DustViewModel
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        stationViewModel = DustViewModel(DustRepository)
        loadData()
        observe()
    }

    private fun loadData() {
        stationViewModel.dust(dustParams())
    }

    private fun observe() {
        stationViewModel.dust.observe(this) {
            it?.let {
                layout(it)
            }
        }

        stationViewModel.loading.observe(this) {
            if (it == true)
                showProgress(binding.progress)
            else
                hideProgress(binding.progress)
        }

        stationViewModel.error.observe(this) {
            ToastFactory.toast(this, R.string.dust_error_msg)
            hideProgress(binding.progress)
        }
    }

    private fun layout(item: DustItem) {
        binding.dustLocalText.text = Constants.LOCATION
        binding.dustBgColor.setBackgroundResource(item.khaiGrade.color)
        with(binding.findDust) {
            dustTitle.text = getString(R.string.find_dust)
            dustState.text = item.pm10Grade.state
            dustValue.text = getString(R.string.find_dust_unit, item.pm10Value)
        }

        with(binding.ultraFindDust) {
            dustTitle.text = getString(R.string.ultra_find_dust)
            dustState.text = item.pm25Grade.state
            dustValue.text = getString(R.string.find_dust_unit, item.pm25Value)
        }

        with(binding.nitrogenDioxide) {
            dustTitle.text = getString(R.string.nitrogen_dioxide)
            dustState.text = item.no2Grade.state
            dustValue.text = getString(R.string.dust_unit, item.no2Value)
        }

        with(binding.ozone) {
            dustTitle.text = getString(R.string.ozone)
            dustState.text = item.o3Grade.state
            dustValue.text = getString(R.string.dust_unit, item.o3Value)
        }

        with(binding.carbonMonoxide) {
            dustTitle.text = getString(R.string.carbon_monoxide)
            dustState.text = item.no2Grade.state
            dustValue.text = getString(R.string.dust_unit, item.coValue)
        }

        with(binding.sulphurDioxide) {
            dustTitle.text = getString(R.string.sulphur_dioxide)
            dustState.text = item.so2Grade.state
            dustValue.text = getString(R.string.dust_unit, item.so2Value)
        }
    }

}