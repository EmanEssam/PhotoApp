package com.test.photoapp.platform.view.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.photoapp.R
import com.test.photoapp.core.helper.helper.LoaderStateAdapter
import com.test.photoapp.core.helper.helper.PhotoBuilder.getPhotoUrl
import com.test.photoapp.databinding.FragmentPhotosBinding
import com.test.photoapp.platform.view.adapter.PhotoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PhotosFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModels()
    lateinit var moviesAdapter: PhotoAdapter
    private lateinit var binding: FragmentPhotosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPhotosBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setUpObservers()

    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            viewModel.getMovies().collectLatest {
                binding.moviesRv.visibility = View.VISIBLE
                moviesAdapter.submitData(it)
                hideProgressDialog()
            }
        }
    }

    private fun setupRecyclerView() {
        moviesAdapter = PhotoAdapter {
            val bundle =
                bundleOf("image" to getPhotoUrl(it.farm, it.server, it.id.toString(), it.secret))
            findNavController().navigate(R.id.action_moviesFragment_to_imageFragment, bundle)
        }
        val layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
        binding.moviesRv.layoutManager = layoutManager
        binding.moviesRv.adapter = moviesAdapter
        binding.moviesRv.adapter = moviesAdapter.withLoadStateFooter(
            footer = LoaderStateAdapter { moviesAdapter.retry() }
        )
        moviesAdapter.addLoadStateListener { loadState ->
            when (loadState.source.refresh) {
                is LoadState.Loading -> showProgressDialog()
                is LoadState.NotLoading -> hideProgressDialog()
                is LoadState.Error -> showLongToast()
            }
        }
    }

    private fun showLongToast() {

    }

    private fun hideProgressDialog() {
        binding.progressBar.visibility = View.GONE

    }

    private fun showProgressDialog() {
        binding.progressBar.visibility = View.VISIBLE
    }
}