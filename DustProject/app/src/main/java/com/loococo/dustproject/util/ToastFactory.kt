package com.loococo.dustproject.util

import android.content.Context
import android.widget.Toast

object ToastFactory {
    fun toast(context: Context, res: Int) {
        if (res > 0) Toast.makeText(context, res, Toast.LENGTH_SHORT).show()
    }

    fun toast(context: Context, res: String) {
        if (res.isNotBlank()) Toast.makeText(context, res, Toast.LENGTH_SHORT).show()
    }
}