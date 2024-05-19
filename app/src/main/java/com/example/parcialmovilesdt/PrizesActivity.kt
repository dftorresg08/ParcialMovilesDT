package com.example.parcialmovilesdt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PrizesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prizes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnStadiums: Button = findViewById(R.id.btnCalculate)
        val btnGoMenu: Button = findViewById(R.id.btnMenu)
        val etMontoDolares: EditText = findViewById(R.id.etMonto)

        val txtb1 = findViewById<TextView>(R.id.txtb1)
        val txtb2 = findViewById<TextView>(R.id.txtb2)
        val txtb3 = findViewById<TextView>(R.id.txtb3)
        val txtb4 = findViewById<TextView>(R.id.txtb4)

        btnStadiums.setOnClickListener {
            val totalAmountStr = etMontoDolares.text.toString()
            if (totalAmountStr.isNotEmpty()) {
                val totalAmount = totalAmountStr.toDouble()
                val firstPlace = 0.25 * totalAmount
                val secondPlace = 0.15 * totalAmount
                val thirdPlace = 0.10 * totalAmount
                val remainingAmount = totalAmount - (firstPlace + secondPlace + thirdPlace)
                val fourthToSixteenthPlace = remainingAmount / 13

                txtb1.text = "1° place 25% -> " + firstPlace.toString()
                txtb2.text = "2° place 15% -> " + secondPlace.toString()
                txtb3.text = "3° place 10% ->" + thirdPlace.toString()
                txtb4.text = "4° - 16° place ->" + fourthToSixteenthPlace.toString()
            }

        btnGoMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            }
        }
    }
}