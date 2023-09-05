package com.android.linerarlayoutpertemuan2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.linerarlayoutpertemuan2.databinding.ActivityBmiBinding
import java.text.DecimalFormat

class BmiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding
    private var count = 0.0
    private var berat = 0.0
    private var tinggi = 0.0

    private var kurus = 18.5
    private var normal = 24.9
    private var gendut = 29.9

    private lateinit var keterangan: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            btnHitung.setOnClickListener {

                try {
                    val simpanBerat = beratBadan.text.toString()
                    val simpanTinggi = tinggiBadan.text.toString()

                    berat = simpanBerat.toDouble()
                    tinggi = simpanTinggi.toDouble()/100

                    count = berat / (tinggi*tinggi)
                    val decimalFormat = DecimalFormat("#.##")
                    count = decimalFormat.format(count).toDouble()

                    if (count <= kurus){
                        keterangan = "Berat Badan Kurang"
                    }
                    else if (count <= normal){
                        keterangan = "Berat Badan Normal"
                    }
                    else if (count <= gendut){
                        keterangan = "Kelebihan Berat Badan"
                    }
                    else {
                        keterangan = "Obesitas"
                    }


                    hasil.text = count.toString()
                    viewKeterangan.text = keterangan
                }
                catch (e: Exception){

                    viewKeterangan.text = "Anda Belum Memasukkan Data"

                }


                btnToast.setOnClickListener {

                    Toast.makeText(this@BmiActivity,"Saya Manusia Sehat", Toast.LENGTH_SHORT).show()

                }


            }



        }



    }
}