package com.lucasfagundes.ioasysbooks.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.ioasysbooks.adapter.BookListAdapter
import com.lucasfagundes.ioasysbooks.databinding.FragmentSearchBooksBinding

lateinit var binding: FragmentSearchBooksBinding

class SearchBooksFragment : Fragment() {

    private lateinit var bookListAdapter: BookListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBooksBinding.inflate(inflater, container, false)
        return binding.root

    }
}