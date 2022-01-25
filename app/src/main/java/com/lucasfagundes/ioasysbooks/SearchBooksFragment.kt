package com.lucasfagundes.ioasysbooks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasfagundes.ioasysbooks.feature.login.presentation.adapter.BookListAdapter
import com.lucasfagundes.ioasysbooks.databinding.FragmentSearchBooksBinding
import com.lucasfagundes.ioasysbooks.feature.login.model.Book

private var _binding: FragmentSearchBooksBinding? = null
private val binding : FragmentSearchBooksBinding get() = _binding!!

class SearchBooksFragment : Fragment() {

    private lateinit var bookListAdapter: BookListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSearchBooksBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBookList()
    }

    private fun setBookList(){
        bookListAdapter = BookListAdapter()
        binding.booksListRecyclerView.adapter = bookListAdapter

        bookListAdapter.submitList(Book.getMockList())
    }
}