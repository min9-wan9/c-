package com.example.bai24_tinhtuoi

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDate = findViewById<Button>(R.id.btnDate)
        btnDate.setOnClickListener {
            tinhTuoi()
        }
    }

    private fun tinhTuoi() {
        val txtSelectDate = findViewById<TextView>(R.id.txtDate)
        val txtAgeMinute = findViewById<TextView>(R.id.txtAgeInMinute)

        // lấy thời gian hiện tại
        val cal = Calendar.getInstance()
        //lấy thời gian hiện tại
        val year1 = cal.get(Calendar.YEAR)
        val month1 = cal.get(Calendar.MONTH)
        val day1 = cal.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(this, "Bạn sinh ngày :$dayOfMonth/${month+1}/${year}", Toast.LENGTH_SHORT).show()
           txtSelectDate.text ="$dayOfMonth/${month+1}/${year}"
                val dateBirth = "$dayOfMonth/${month+1}/${year}"
                val sdf = SimpleDateFormat("dd/MM/yyyy")
                var date = sdf.parse(dateBirth)
                val nsphut = date.time/60000

                // lấy ngày hiện tịa
                val current = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currMintues = current.time/60000
                val tg =  currMintues- nsphut

                txtAgeMinute.text = tg.toString()

                                               }
        ,year1,month1,day1).show()


    }
}