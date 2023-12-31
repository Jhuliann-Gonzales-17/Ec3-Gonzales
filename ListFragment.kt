package com.monica.ec3_monica_gonzales_.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.viewModelScope
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.monica.ec3_monica_gonzales_.databinding.FragmentListBinding
import com.monica.ec3_monica_gonzales_.viewModels.ListViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RvListAdapter(listOf())
        binding.rvList.adapter = adapter
        binding.rvList.layoutManager =GridLayoutManager(requireContext(),2, RecyclerView.VERTICAL,false)
        viewModel.list.observe(requireActivity()) {
            adapter.lista= it
            adapter.notifyDataSetChanged()
        }
        viewModel.getListFromService()
    }

}