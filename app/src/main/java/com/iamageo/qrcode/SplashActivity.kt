package com.iamageo.qrcode

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.iamageo.qrcode.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) //delay em millisegundos.
    }
}