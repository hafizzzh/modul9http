package com.hafizh.modul9http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Headers
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
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
        "${mUrl}login?email=${userName}&password=${password}"
            .httpGet()
            .responseString { request: Request, response: Response, result: Result<String, FuelError> ->
                when (result) {
                    is Result.Success -> {
                        Log.e("RESPONSE", response.toString())
                        tvResponse.text = response.body()
                            .asString(response.get(Headers.CONTENT_TYPE).lastOrNull())
                    }
                    is Result.Failure -> {
                        Log.e("FAILURE", response.toString())
                        tvResponse.text = response.body()
                            .asString(response.get(Headers.CONTENT_TYPE).lastOrNull())
                    }
                }
            }
    }
}