package com.example.customviewtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customviewtutorial.customview.CustomImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addCustomView()
    }

    private fun addCustomView() {
        val customImageView = CustomImageView(this)
        with(container) {
            removeAllViews()
            addView(customImageView)
        }
    }
}