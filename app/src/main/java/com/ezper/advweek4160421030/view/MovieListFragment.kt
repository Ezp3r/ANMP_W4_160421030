package com.ezper.advweek4160421030.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ezper.advweek4160421030.R
import com.ezper.advweek4160421030.databinding.FragmentMovieListBinding
import com.ezper.advweek4160421030.databinding.MovieListItemBinding
import com.ezper.advweek4160421030.viewmodel.MovieViewModel


class MovieListFragment : Fragment() {
    private lateinit var binding: FragmentMovieListBinding
    private lateinit var viewModel: MovieViewModel
    private val movieListAdapter = MovieListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.refresh()

        binding.recMovie.layoutManager = LinearLayoutManager(context)
        binding.recMovie.adapter = movieListAdapter

        observeViewModel()

        binding.movieRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
            binding.recMovie.visibility = View.GONE
            binding.txtMovieError.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            binding.movieRefreshLayout.isRefreshing = false
        }

    }

    fun observeViewModel() {
        viewModel.moviesLD.observe(viewLifecycleOwner, Observer {
            movieListAdapter.updateMovieList(it)
        })

        viewModel.movieLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if (it == true){
                binding.txtMovieError.visibility = View.VISIBLE
            }
            else{
                binding.txtMovieError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                binding.progressBar.visibility = View.VISIBLE
                binding.recMovie.visibility = View.GONE
            }
            else{
                binding.progressBar.visibility = View.GONE
                binding.recMovie.visibility = View.VISIBLE
            }
        })
    }


}