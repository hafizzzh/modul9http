package com.hafizh.modul9http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class LoginActivity : AppCompatActivity() {

    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var btnLogin: MaterialButton
    private lateinit var tvResponse: TextView
    private val mUrl = "https://retrofit.tumbasbarang.xyz/api/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        inputEmail = findViewById(R.id.input_email)
        inputPassword = findViewById(R.id.input_password)
        btnLogin = findViewById(R.id.btn_login)
        tvResponse = findViewById(R.id.tv_response)

        btnLogin.setOnClickListener {
            loginn(
                userName = inputEmail.editText?.text.toString(),
                password = inputPassword.editText?.text.toString()
            )
        }


    }

    private fun loginn(userName: String, password: String) {
        val client =
    }


    private fun doRequest(userName: String, password: String) {
        var reqParam = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8")
        reqParam += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")

        val mURL = URL(mUrl+"login?"+reqParam)

        with(mURL.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "GET"

            Log.e("URL", url.toString())
            Log.e("RESPONSE", responseCode.toString())

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                it.close()
                tvResponse.text = response
                println("Response : $response")
            }
        }
    }
}