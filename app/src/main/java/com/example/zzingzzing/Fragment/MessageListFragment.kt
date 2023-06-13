package com.example.zzingzzing.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zzingzzing.Adapter.MessageListAdapter
import com.example.zzingzzing.AppApplication
import com.example.zzingzzing.ViewModel.AppViewModel
import com.example.zzingzzing.ViewModel.AppViewModelFactory
import com.example.zzingzzing.databinding.FragmentMessageListBinding
import kotlin.properties.ReadOnlyProperty

class MessageListFragment : Fragment() {
    private lateinit var binding: FragmentMessageListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appViewModel : AppViewModel by activityViewModels()

        val recyclerView = binding.rcMessageList
        val adapter = MessageListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
    }
}