package com.example.trymovedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var nim: String
    private lateinit var name: String
    private lateinit var major: String
    private lateinit var address: String
    private lateinit var dob: String
    private lateinit var mGender : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initiateListener()

    }

    private fun initiateListener() {
        btn_submit.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View){
        //Get the clicked radio button instance
        if(view is RadioButton){

            val checked = view.isChecked

            when(view.getId()){

                R.id.rb_male -> {
                    mGender = "Male"
                }

                R.id.rb_female -> {
                    mGender = "Female"
                }

            }

        }
    }

    private fun checkValue(): Boolean {
        nim = input_nim.text.toString().trim()
        name = input_name.text.toString().trim()
        major = input_major.text.toString().trim()
        address = input_address.text.toString().trim()
        dob = input_dob.text.toString().trim()
        val id = rg_gender.checkedRadioButtonId

        return nim.isNotEmpty() && name.isNotEmpty() && major.isNotEmpty() && address.isNotEmpty() && dob.isNotEmpty() && id != -1

    }

    override fun onClick(v: View?) {

        if(checkValue()){
            //intent
            if(v?.id == R.id.btn_submit){
                val move = Intent(this@MainActivity, DataActivity::class.java)
                val data = Data(
                    nim,
                    name,
                    major,
                    address,
                    dob,
                    mGender
                )
                move.putExtra(DataActivity.EXTRA_DATA, data)
                startActivity(move)

            }

        }

        else{
            Toast.makeText(applicationContext, "All fields required", Toast.LENGTH_SHORT).show()
        }

    }

}