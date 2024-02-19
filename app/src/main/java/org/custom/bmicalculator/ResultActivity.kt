package org.custom.bmicalculator

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColor
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        val height:Int = intent.getIntExtra("height",0)
        val weight:Int = intent.getIntExtra("weight",0)

        val bmi = weight / (height  / 100.0).pow(2.0)
        var resultText:String = ""
        var backgroundColor: Color = Color.RED.toColor()

       if (bmi < 18.5) {
           backgroundColor = Color.RED.toColor()
           resultText = "저체중"
       }
       else  if (18.5 <= bmi && bmi < 23.0) {
           backgroundColor = Color.GREEN.toColor()
           resultText = "정상 체중"
       }

       else  if (23.0 <= bmi && bmi < 25.0) {
           backgroundColor = Color.GRAY.toColor()
           resultText = "과체중"
       }
       else  if (25.0 <= bmi && bmi < 30.0) {
           backgroundColor = Color.YELLOW.toColor()
           resultText = "중정도 비만"
       }
       else  if (30.0 <= bmi && bmi < 35.0) {
           backgroundColor = Color.RED.toColor()
           resultText = "고도 비만"
       }else{
           backgroundColor = Color.RED.toColor()
           resultText = "초고도 비만"
       }
        val result1:TextView = findViewById(R.id.result)
        val result2:TextView = findViewById(R.id.result2)
        val userStatusImage:ImageView = findViewById(R.id.userStatus)
        result1.text = height.toString()
        result2.text = resultText

        userStatusImage.background = backgroundColor.toDrawable()



        val backButton = findViewById<Button>(R.id.backButton)


        backButton.setOnClickListener({
            finish()
        })
    }
}