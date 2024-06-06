package com.ezper.advweek4160421030.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ezper.advweek4160421030.R
import com.ezper.advweek4160421030.databinding.FragmentStudentDetailBinding
import com.ezper.advweek4160421030.databinding.FragmentStudentListBinding
import com.ezper.advweek4160421030.model.Student
import com.ezper.advweek4160421030.viewmodel.DetailViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.Exception
import java.util.concurrent.TimeUnit


class StudentDetailFragment : Fragment()
    , ButtonDetailClickListener {
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

//      val studentId = arguments?.getString("studentId") ?: ""

        var id = ""
        if (arguments!=null){
            id = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        }

        viewModel.fetch(id)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner,
            Observer {
//                Student ->
//            binding.apply {
//                txtId.setText(Student[0].id)
//                txtName.setText(Student[0].name)
//                txtBod.setText(Student[0].dob)
//                txtPhone.setText(Student[0].phone)
//
//                val picasso = Picasso.Builder(imageViewDetail.context)
//                picasso.listener { picasso, uri, exception ->
//                    exception.printStackTrace()
//                }
//
//                picasso.build().load(Student[0].photoUrl).into(binding.imageViewDetail, object:
//                    Callback {
//                    override fun onSuccess() {
//                    }
//
//                    override fun onError(e: Exception?) {
//                        Log.e("picasso_error", e.toString())
//                    }
//
//                })
//
//            }


//            binding.btnUpdate.setOnClickListener {
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        Log.d("Messages", "five seconds")
//                        MainActivity.showNotification(Student[0].name.toString(),
//                        "A new notification created",
//                        R.drawable.baseline_person_24)
//                    }
//            }

                binding.student = it
                binding.clickListener = this

                var student = it
                binding.btnUpdate.setOnClickListener {
                    Observable.timer(5, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { Log.d("Messages", "five seconds")

                        MainActivity.showNotification(student.name.toString(), "A new notification", R.drawable.baseline_person_24)
                    }
                }

            })
    }

    override fun onButtonDetailClick(v: View) {
        Toast.makeText(v.context, "Updated", Toast.LENGTH_SHORT).show()
    }

}