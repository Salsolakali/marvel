package com.example.marvel.features.home.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvel.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var charactersAdapter: CharactersAdapter

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUI()
    }

    private fun initUI() {
        initRecycler()
        initListeners()
        setUpObservers()
    }

    private fun initRecycler() {
        binding.recyclerHome.layoutManager = LinearLayoutManager(this)
        binding.recyclerHome.adapter = charactersAdapter
    }

    private fun initListeners() {
        charactersAdapter.clickListener = {
            //TODO show character detail
        }
    }

    private fun setUpObservers() {
        homeViewModel.charactersFetched.observe(this) { result ->

            result.doIfSuccess {
                //TODO show items
            }

            result.doIfFailure {
                //TODO manage error
            }

            result.doIfInProgress {
                //TODO show loading
            }

        }
    }
}