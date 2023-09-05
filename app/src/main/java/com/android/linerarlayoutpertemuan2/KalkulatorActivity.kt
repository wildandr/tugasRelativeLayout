package com.android.linerarlayoutpertemuan2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.android.linerarlayoutpertemuan2.databinding.ActivityKalkulatorBinding


class KalkulatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKalkulatorBinding

    private var hasilHitung = 0.0
    private  var operatorVar = "+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKalkulatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editText = findViewById<EditText>(R.id.text_input)
        editText.requestFocus()
        editText.showSoftInputOnFocus = false


        with(binding){

            fun setButtonClickListener(button: Button, newNumber: String) {
                button.setOnClickListener {
                    val caretPosition: Int = textInput.selectionStart

                    val updatedText: String =
                        textInput.text.toString().substring(0, caretPosition) + newNumber + textInput.text.toString().substring(
                            caretPosition
                        )
                    textInput.setText(updatedText)
                    textInput.setSelection(caretPosition+1)
                }
            }

            setButtonClickListener(button1, "1")
            setButtonClickListener(button2, "2")
            setButtonClickListener(button3, "3")
            setButtonClickListener(button4, "4")
            setButtonClickListener(button5, "5")
            setButtonClickListener(button6, "6")
            setButtonClickListener(button7, "7")
            setButtonClickListener(button8, "8")
            setButtonClickListener(button9, "9")

            button0.setOnClickListener{
                if (textInput.length()>0 && textInput.selectionStart > 0){
                    val caretPosition: Int = textInput.selectionStart
                    val newNumber = "0"

                    val updatedText: String =
                        textInput.text.toString().substring(0, caretPosition) + newNumber + textInput.text.toString().substring(
                            caretPosition
                        )
                    textInput.setText(updatedText)

                    textInput.setSelection(caretPosition+1)
                }
            }

            // ...

            del.setOnClickListener {
                val caretPosition: Int = textInput.selectionStart

                if (caretPosition > 0) {
                    val text = textInput.text.toString()
                    val updatedText: String = text.substring(0, caretPosition - 1) + text.substring(caretPosition)
                    textInput.setText(updatedText)
                    textInput.setSelection(caretPosition - 1)
                }
            }

            clear.setOnClickListener{
                textInput.setText("")
                hasilHitung = 0.0
                operator.text = ""
                textHasil.visibility = View.GONE
            }

            buttonPlus.setOnClickListener{

                try{
                    when(operatorVar){
                        "+" -> hasilHitung += textInput.text.toString().toDouble()
                        "-" -> hasilHitung -= textInput.text.toString().toDouble()
                        "/" -> hasilHitung /= textInput.text.toString().toDouble()
                        "*" -> hasilHitung *= textInput.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }

                operator.text = "+"
                operatorVar = "+"

                textInput.setText("")
                textHasil.text = hasilHitung.toString()
                textHasil.visibility = View.VISIBLE
            }

            buttonMinus.setOnClickListener{
                try{
                    when(operatorVar){
                        "+" -> hasilHitung += textInput.text.toString().toDouble()
                        "-" -> hasilHitung -= textInput.text.toString().toDouble()
                        "/" -> hasilHitung /= textInput.text.toString().toDouble()
                        "*" -> hasilHitung *= textInput.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }

                operator.text = "-"
                operatorVar = "-"

                textInput.setText("")
                textHasil.text = hasilHitung.toString()
                textHasil.visibility = View.VISIBLE
            }

            buttonPer.setOnClickListener{
                try{
                    when(operatorVar){
                        "+" -> hasilHitung += textInput.text.toString().toDouble()
                        "-" -> hasilHitung -= textInput.text.toString().toDouble()
                        "/" -> hasilHitung /= textInput.text.toString().toDouble()
                        "*" -> hasilHitung *= textInput.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }

                operator.text = "/"
                operatorVar = "/"

                textInput.setText("")
                textHasil.text = hasilHitung.toString()
                textHasil.visibility = View.VISIBLE
            }

            buttonTimes.setOnClickListener{
                try{
                    when(operatorVar){
                        "+" -> hasilHitung += textInput.text.toString().toDouble()
                        "-" -> hasilHitung -= textInput.text.toString().toDouble()
                        "/" -> hasilHitung /= textInput.text.toString().toDouble()
                        "*" -> hasilHitung *= textInput.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }

                operator.text = "*"
                operatorVar = "*"

                textInput.setText("")
                textHasil.text = hasilHitung.toString()
                textHasil.visibility = View.VISIBLE
            }

            buttonEquals.setOnClickListener{

                try{
                    when(operatorVar){
                        "+" -> hasilHitung += textInput.text.toString().toDouble()
                        "-" -> hasilHitung -= textInput.text.toString().toDouble()
                        "/" -> hasilHitung /= textInput.text.toString().toDouble()
                        "*" -> hasilHitung *= textInput.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }

                operatorVar = "+"
                operator.text = ""


                textInput.setText(hasilHitung.toString())
                hasilHitung = 0.0

                textHasil.visibility = View.GONE
                textInput.setSelection(textInput.text.length)
            }

        }
    }
}
