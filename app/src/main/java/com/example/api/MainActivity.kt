package com.example.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.api.API.APInterface
import com.example.api.API.RetrofitInstance
import com.example.api.databinding.ActivityMainBinding
import com.example.api.models.CryptoNews
import com.example.api.models.CryptoNewsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var finalArray = ArrayList<CryptoNews>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.text1.setOnClickListener {
            RetrofitInstance.cryptoInstance().create(APInterface::class.java).getCrypto()
                .enqueue(object : Callback<CryptoNewsItem?>{
                    override fun onResponse(
                        call: Call<CryptoNewsItem?>,
                        response: Response<CryptoNewsItem?>
                    ){
                        var res = response.body()
                        binding.latitude.text = res?.description
                       // Log.d("TAG---->",res!!.title)
                    }

                    override fun onFailure(call: Call<CryptoNewsItem?>, t: Throwable) {
                        Log.d("TAG---->",t.message.toString())
                    }
                })
        }
        setContentView(binding.root)
    }
}

