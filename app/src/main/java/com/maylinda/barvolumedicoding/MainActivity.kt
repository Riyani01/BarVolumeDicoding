package com.maylinda.barvolumedicoding

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         edtWidth = findViewById(R.id.edt_width)
         edtLength = findViewById(R.id.edt_leght)
         edtHeight = findViewById(R.id.edt_height)
         btnCalculate = findViewById(R.id.btn_calculate)
         tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(v: View?) {
       if (v?.id == R.id.btn_calculate) {

           val inputLength = edtLength.text.toString().trim()
           val inputWidth = edtWidth.text.toString().trim()
           val inputHeight = edtHeight.text.toString().trim()

           var isEmptyFiels = false
           if (inputLength.isEmpty()) {
               isEmptyFiels = true
               edtLength.error = "Field ini tidak boleh kosong !"
           }
           if (inputWidth.isEmpty()) {
               isEmptyFiels = true
               edtWidth.error = "Field ini tidak boleh kosong !"
           }
           if (inputHeight.isEmpty()) {
               isEmptyFiels = true
               edtHeight.error = "Field ini tidak boleh kosong !"
           }
           if (!isEmptyFiels) {
               val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
               tvResult.text = volume.toString()
           }
       }
    }
}