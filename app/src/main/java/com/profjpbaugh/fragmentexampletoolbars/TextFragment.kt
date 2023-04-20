package com.profjpbaugh.fragmentexampletoolbars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.profjpbaugh.fragmentexampletoolbars.databinding.FragmentTextBinding

class TextFragment : Fragment() {

    private lateinit var binding : FragmentTextBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun changeTextProperties(text : String) {
        binding.textView2.text = text

    }

}