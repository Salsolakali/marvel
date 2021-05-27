package com.example.marvel.features.detail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvel.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val CHARACTER_KEY = "character_key"
        fun buildIntent(context: Context, detailBundle: Bundle): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtras(detailBundle)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}