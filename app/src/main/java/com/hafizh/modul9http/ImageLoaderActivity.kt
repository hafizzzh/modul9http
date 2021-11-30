package com.hafizh.modul9http

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import java.io.IOException
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class ImageLoaderActivity : AppCompatActivity() {

    private lateinit var iv: ImageView
    private var bitmap: Bitmap? = null
    private var mUrl: String = "https://source.unsplash.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_loader)

        iv = findViewById(R.id.iv_main)

        findViewById<MaterialButton>(R.id.btn_load_img).setOnClickListener {
            loadImage()
        }
    }

    private fun loadImage() {
        Glide.with(this)
            .load(mUrl + (300..310).random() + "x" + (400..410).random())
            .into(iv)
    }


}