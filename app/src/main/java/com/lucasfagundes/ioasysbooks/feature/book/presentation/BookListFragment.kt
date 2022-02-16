package com.lucasfagundes.ioasysbooks.feature.book.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.view.ViewGroup
import com.lucasfagundes.ioasysbooks.utils.ViewState
import com.lucasfagundes.ioasysbooks.databinding.FragmentBookListBinding
import com.lucasfagundes.ioasysbooks.feature.book.adapter.BookListAdapter
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.feature.book.adapter.BookClickListener

class SearchBooksFragment : Fragment(), BookClickListener {

    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    private val bookViewModel: BookListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchListener()
        addObserver()
    }

    private fun searchListener() {
        binding.searchCustomView.textChangeListener = { input ->
            bookViewModel.getBooks(input)
        }
    }

    private fun addObserver() {
        bookViewModel.bookListViewState.observe(viewLifecycleOwner) { state ->

            when (state) {
                is ViewState.Success -> {
                    val bookListAdapter = BookListAdapter(this)
                    binding.booksListRecyclerView.adapter = bookListAdapter
                    bookListAdapter.submitList(state.data)
                }
                is ViewState.Error -> Unit
                else -> Unit
            }
        }
    }

    private fun showEmptyListError(hasError: Boolean) {
        binding.errorTextView.visibility = if (hasError) View.VISIBLE else View.GONE
    }

    override fun onBookClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager, "book")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}