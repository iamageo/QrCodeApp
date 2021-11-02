package com.iamageo.qrcode.base

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity(): AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

    }

}