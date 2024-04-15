package com.example.lectionfragments.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lectionfragments.R
import com.example.lectionfragments.viewmodel.SharedViewModel

class ContactFragment : Fragment() {
    //private lateinit var viewModel: SharedViewModel
    private val viewModel: SharedViewModel by activityViewModels()

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java) // [SharedViewModel::class.java]
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val EditText = view.findViewById<EditText>(R.id.edittext_msg)
        val myButton = view.findViewById<Button>(R.id.btn_sender)

        myButton.setOnClickListener {
            viewModel.setMessage(EditText.text.toString())
        }
    }
}