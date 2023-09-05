package com.android.linerarlayoutpertemuan2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.linerarlayoutpertemuan2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0
    private var istigfar = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            btnCount.setOnClickListener {
                count ++
                viewCount.text = count.toString()
            }

            btnIstighfar.setOnClickListener {
                istigfar++
                Toast.makeText(this@MainActivity, "Astagfirullah $istigfar", Toast.LENGTH_SHORT).show()

            }

            btnReset.setOnClickListener {
                count = 0
                viewCount.text = count.toString()
            }

        }
    }
}