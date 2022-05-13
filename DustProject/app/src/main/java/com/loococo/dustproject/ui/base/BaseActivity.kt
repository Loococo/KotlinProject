package com.loococo.dustproject.ui.base

import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ContentLoadingProgressBar
import com.loococo.dustproject.common.Constants


open class BaseActivity : AppCompatActivity() {

    fun dustParams(): HashMap<String, String> {
        return hashMapOf(
            "serviceKey" to Constants.DUST_SERVICE_KEY,
            "returnType" to "json",
            "numOfRows" to "100",
            "pageNo" to "1",
            "stationName" to Constants.LOCATION,
            "dataTerm" to "DAILY",
            "ver" to "1.3"
        )
    }

    fun showProgress(progress: ContentLoadingProgressBar) {
        if (progress.visibility != View.VISIBLE) {
            progress.visibility = View.VISIBLE
            window.setFlags(
                WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        }
    }

    fun hideProgress(progress: ContentLoadingProgressBar) {
        if (progress.visibility != View.GONE) {
            progress.visibility = View.GONE
            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }
}