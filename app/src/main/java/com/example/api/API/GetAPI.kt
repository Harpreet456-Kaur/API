package com.example.api.API

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.api.Observer
import com.example.api.R
import com.example.api.databinding.ActivityGetApiBinding
import com.example.api.models.CryptoNewsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class GetAPI : AppCompatActivity() {
    lateinit var binding: ActivityGetApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.getBtn.setOnClickListener {
            // getData()
        }
    }

    private fun getData() {
        RetrofitInstance.retrofitInstance().create(APInterface::class.java).getData()
            .enqueue(object : Callback<NewData?> {
                override fun onResponse(call: Call<NewData?>, response: Response<NewData?>) {
                    val res = response.body()

                    for (i in res!!.indices){
                        binding.data.text = res[i].title
                        Log.d("TAG--->",res[i].title)

                        val list = ArrayList<NewData>()
                            binding.data.text = list.toString()
                        }

                    Toast.makeText(this@GetAPI, "Done", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<NewData?>, t: Throwable) {
                    Log.d("TAG--->",t.message.toString())
                }
            })
    }
}