package com.ezper.advweek4160421030.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ezper.advweek4160421030.R
import com.ezper.advweek4160421030.databinding.FragmentStudentDetailBinding
import com.ezper.advweek4160421030.databinding.FragmentStudentListBinding

class StudentDetailFragment : Fragment() {
    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}