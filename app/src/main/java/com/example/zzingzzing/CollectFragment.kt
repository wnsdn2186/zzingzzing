package com.example.zzingzzing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zzingzzing.databinding.FragmentCollectBinding

class CollectFragment : Fragment() {
    private lateinit var binding: FragmentCollectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCollectBinding.inflate(inflater, container, false)
        return binding.root
    }
}