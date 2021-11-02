package com.iamageo.qrcode

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.iamageo.qrcode.base.BaseActivity
import com.iamageo.qrcode.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScanner.setOnClickListener { initScanner() }
    }

    private fun initScanner(){
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Aponte a câmera para o QR Code.")
        integrator.setTorchEnabled(true)
        integrator.setBeepEnabled(false)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                setupQRWithoutContent()
            } else {
                setupQRWithContent(result)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun setupQRWithoutContent() {
        binding.linearLayoutContent.visibility = View.GONE
    }

    private fun setupQRWithContent(result: IntentResult) {
        binding.linearLayoutContent.visibility = View.VISIBLE
        binding.tvContent.text = result.contents
    }
}
