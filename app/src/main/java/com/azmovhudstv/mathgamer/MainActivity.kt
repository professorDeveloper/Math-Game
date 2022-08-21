package com.azmovhudstv.mathgamer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.TextureView
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var random:kotlin.random.Random
    var result:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        random= Random(2)
        var true1=0
        var edit=findViewById<EditText>(R.id.editTextTextPersonName)
        setElements()

        var nextb=findViewById<Button>(R.id.button)
        nextb.setOnClickListener {

            val toString = edit.text.toString()
            if (edit.text.isEmpty()) {
                edit.error = "Enter Result"
            } else {
                if (toString == result.toString()) {
                    Toast.makeText(this, "Togri", Toast.LENGTH_LONG).show()
                    setElements()
                    true1++
                    var score = findViewById<TextView>(R.id.score)
                    score.text = true1.toString()

                } else {
                    Toast.makeText(this, "notugri", Toast.LENGTH_LONG).show()
                    setElements()


                }
                edit.setText("")
            }
        }
    }

    private fun setElements() {
        var amal=findViewById<TextView>(R.id.amal)
        var son1=random.nextInt(10,50)
        var son2=random.nextInt(1,15)

        var number1=findViewById<TextView>(R.id.number1)
        var number2=findViewById<TextView>(R.id.number2)
        number1.text=son1.toString()
        number2.text=son2.toString()
        var n= random.nextInt(4)
        when(n){
            0->{
                amal.text="+"
                result=son1+son2.toInt()

            }
            1->{
                amal.text="/"
                result=son1/son2.toInt()

            }
            2->{
                amal.text="*"
                result=son1*son2.toInt()

            }
            3->{
                amal.text="-"
                result=son1-son2.toInt()

            }
        }
    }
}