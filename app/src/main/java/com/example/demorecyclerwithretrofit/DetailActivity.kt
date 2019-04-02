package com.example.demorecyclerwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        text_title.text = intent.getStringExtra("title")
        text_body.text = intent.getStringExtra("body")
    }
}
