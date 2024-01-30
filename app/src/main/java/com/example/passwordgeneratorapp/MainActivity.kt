package com.example.passwordgeneratorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var passwordLength: Int = 10
        var isUppercaseRange: Boolean = false
        var isLowercaseRange: Boolean = false
        var isNumbersRange: Boolean = false
        var isSpecialRange: Boolean = false

        var length = findViewById<EditText>(R.id.et_password_length)

        var switchUppercaseRange = findViewById<Switch>(R.id.switch_uppercase)
        switchUppercaseRange.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                isUppercaseRange = true
            }else{
                isUppercaseRange = false
            }
        }
        var switchLowercaseRange = findViewById<Switch>(R.id.switch_lowercase)
        switchLowercaseRange.setOnCheckedChangeListener { switch, isChecked ->
            if(isChecked){
                isLowercaseRange = true
            }else{
                isLowercaseRange = false
            }
        }
        var switchNumbersRange = findViewById<Switch>(R.id.switch_numbers)
        switchNumbersRange.setOnCheckedChangeListener { switch, isChecked ->
            if(isChecked){
                isNumbersRange = true
            }else{
                isNumbersRange = false
            }
        }
        var switchSpecialRange = findViewById<Switch>(R.id.switch_special)
        switchSpecialRange.setOnCheckedChangeListener { switch, isChecked ->
            if(isChecked){
                isSpecialRange = true
            }else{
                isSpecialRange = false
            }
        }

        var buttonGenerate = findViewById<Button>(R.id.btn_generate)
        buttonGenerate.setOnClickListener {
            if(isUppercaseRange == true) userCustomRange += uppercaseRange
            if(isLowercaseRange == true) userCustomRange += lowercaseRange
            if(isNumbersRange == true) userCustomRange += numberRange
            if(isSpecialRange == true) userCustomRange += symbolRange
            val password = passwordGenerator(passwordLength, userCustomRange)
            var resultGeneration = findViewById<TextView>(R.id.tv_result_generation)
            resultGeneration.setText(password)

        }

    }
}
val uppercaseRange = 'A'..'Z'
val lowercaseRange = 'a'..'z'
val numberRange = 0..9
val symbolRange = '!'..'&'
var userCustomRange: List<Any> = listOf()
fun passwordGenerator(lengthPassword: Int, userCustomRange: List<Any>) :String{

    var password: String = ""

    while (password.length < lengthPassword){
        password += userCustomRange.random().toString()
    }
    return password
}