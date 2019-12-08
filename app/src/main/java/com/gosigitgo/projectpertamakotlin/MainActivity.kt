package com.gosigitgo.projectpertamakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //3 menyimpan const
    companion object {
        private const val STATE_RESULT = "state_result"
    }
    //4 mengatur agar bisa menyimpan hasil walaupun di rotate
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tv_hasil.text.toString())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1, karena cuma mengarah ke satu activity jadi extend ke view.onclicklistener kemudian implement method
        btn_kalkulator.setOnClickListener(this)
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tv_hasil.text = result
        }
    }
    //2
    override fun onClick(v: View) {
        if (v.id == R.id.btn_kalkulator) {
            val inputFirstValue = edt_firstvalue.text.toString().trim()
            val inputSecondValue = edt_secondvalue.text.toString().trim()

            var isEmptyField = false
            if (inputFirstValue.isEmpty()) {
                isEmptyField = true
                edt_firstvalue.error = "Cannot Empty Field"
            }
            if (inputSecondValue.isEmpty()) {
                isEmptyField = true
                edt_secondvalue.error = "Cannot Empty Field"
            }
            if (!isEmptyField) {
                val result = inputFirstValue.toDouble() * inputSecondValue.toDouble()
                tv_hasil.text = result.toString()
            }
        }
    }
}
