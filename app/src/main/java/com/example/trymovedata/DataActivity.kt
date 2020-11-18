package com.example.trymovedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val data = intent.getParcelableExtra<Data>(EXTRA_DATA)

        out_nim.text = data?.nim
        out_name.text = data?.name
        out_major.text = data?.major
        out_address.text = data?.address
        out_dob.text = data?.dob
        out_gender.text = data?.gender

    }
}