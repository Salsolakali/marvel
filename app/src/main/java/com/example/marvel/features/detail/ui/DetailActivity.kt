package com.example.marvel.features.detail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvel.core.extensions.loadFromUrl
import com.example.marvel.databinding.ActivityDetailBinding
import com.example.marvel.features.home.domain.model.Character

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

    private fun getDetails() = intent.extras?.getSerializable(CHARACTER_KEY) as Character?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUI(getDetails())
    }

    private fun initUI(character: Character?) {
        binding.imageDetail.loadFromUrl(character?.image ?: "")
        binding.tvName.text = character?.name
        binding.tvDescription.text = character?.description
    }
}