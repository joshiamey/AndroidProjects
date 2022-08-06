package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding

    private val myName: MyName = MyName(name = "Ameya Joshi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName
//        val button : Button = findViewById(R.id.done_button)
//
//        button.setOnClickListener {
//            addNickName(it)
//        }

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view: View) {
        // Without Data binding
//        val editText = findViewById<EditText>(R.id.nickNameEdit);
//        val nickNameText = findViewById<TextView>(R.id.nickname_text);
//
//        nickNameText.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nickNameText.visibility = View.VISIBLE

        binding.apply {
//            nicknameText.text = binding.nicknameText.text
            myName?.nickname = nickNameEdit.text.toString()
            invalidateAll()
            nickNameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}