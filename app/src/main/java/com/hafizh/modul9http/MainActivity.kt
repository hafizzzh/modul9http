package com.hafizh.modul9http

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.btn_goto_img).setOnClickListener {
            startActivity(Intent(this, ImageLoaderActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.btn_goto_login).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}