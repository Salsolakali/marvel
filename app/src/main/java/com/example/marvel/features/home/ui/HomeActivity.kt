package com.example.marvel.features.home.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvel.R
import com.example.marvel.core.domain.RequestFailure
import com.example.marvel.core.extensions.doIfFailure
import com.example.marvel.core.extensions.doIfInProgress
import com.example.marvel.core.extensions.doIfSuccess
import com.example.marvel.core.presentation.Navigator
import com.example.marvel.databinding.ActivityHomeBinding
import com.example.marvel.features.detail.ui.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var charactersAdapter: CharactersAdapter

    @Inject
    lateinit var navigator: Navigator

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
        homeViewModel.fetchCharacters()
    }

    private fun initRecycler() {
        binding.recyclerHome.layoutManager = LinearLayoutManager(this)
        binding.recyclerHome.adapter = charactersAdapter
    }

    private fun initListeners() {
        charactersAdapter.clickListener = {
            var bundle = Bundle().apply {
                putSerializable(DetailActivity.CHARACTER_KEY, it)}
                navigator.navigateToDetail(this, bundle, this)
        }
    }

    private fun setUpObservers() {
        homeViewModel.charactersFetched.observe(this) { result ->

            result.doIfSuccess { items ->
                hideLoading()
                charactersAdapter.collection = items
            }

            result.doIfFailure {
                hideLoading()
                manageError(it)
            }

            result.doIfInProgress {
                showLoading()
            }

        }
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun manageError(requestFailure: RequestFailure) {
        val message = when (requestFailure) {
            is RequestFailure.ApiError -> requestFailure.message
            is RequestFailure.NoConnectionError -> getString(R.string.connection_error_message)
            else -> getString(R.string.default_error_message)
        }
        if (message.isNullOrEmpty()) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}