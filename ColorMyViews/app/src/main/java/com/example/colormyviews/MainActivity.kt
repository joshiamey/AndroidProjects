package com.example.colormyviews

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
// required for accessing views in the layout directly
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val boxOneText = findViewById<TextView>(R.id.box_one_text)
//        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
//        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
//        val boxFourText = findViewById<TextView>(R.id.box_four_text)
//        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val viewList: List<View> = listOf(box_one_text,box_two_text,box_five_text,
            box_four_text,box_three_text,constraint_layout,red_button,yellow_button
            ,green_button)

        for (viewItem in viewList) {
            viewItem.setOnClickListener { 
                changeColor(it) }
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun changeColor(view: View) {
        when(view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // boxes using android colors for background
            R.id.box_three_text -> view.setBackgroundColor(getColor(android.R.color.holo_green_light))
            R.id.box_four_text -> view.setBackgroundColor(getColor(android.R.color.holo_green_dark))
            R.id.box_five_text -> view.setBackgroundColor(getColor(android.R.color.holo_green_light))

            // boxes using custom colors
            R.id.red_button -> box_three_text.setBackgroundColor(getColor(R.color.my_red))
            R.id.yellow_button -> box_four_text.setBackgroundColor(getColor(R.color.my_yellow))
            R.id.green_button -> box_five_text.setBackgroundColor(getColor(R.color.my_green))

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}