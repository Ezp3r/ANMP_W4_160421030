package com.ezper.advweek4160421030.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ezper.advweek4160421030.R
import com.ezper.advweek4160421030.databinding.FragmentStudentDetailBinding
import com.ezper.advweek4160421030.databinding.FragmentStudentListBinding
import com.ezper.advweek4160421030.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var binding: FragmentStudentDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer { Student ->
            binding.apply {
                txtId.setText(Student.id)
                txtName.setText(Student.name)
                txtBod.setText(Student.dob)
                txtPhone.setText(Student.phone)
            }
        })
    }

}