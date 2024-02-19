package org.custom.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resultGetButton:Button = findViewById<Button>(R.id.resultGetButton)
        val kindeyText = findViewById<EditText>(R.id.kindey)
        val weightText = findViewById<EditText>(R.id.weight)
        resultGetButton.setOnClickListener {
            if(kindeyText.text.isEmpty()){
                Toast.makeText(this,"신장이 비어 있습니다.",Toast.LENGTH_SHORT).show()
                
                return@setOnClickListener
            }
            else if(weightText.text.isEmpty()){
                Toast.makeText(this,"체중이 비어 있습니다.",Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }
            val height = kindeyText.text.toString().toInt()
            val weight = weightText.text.toString().toInt()
            val intent:Intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            startActivity(intent)


        }

    }
}