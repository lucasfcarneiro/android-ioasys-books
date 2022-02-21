package com.lucasfagundes.ioasysbooks.feature.book.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.lucasfagundes.ioasysbooks.databinding.FragmentBookListBinding
import com.lucasfagundes.ioasysbooks.domain.exception.EmptyBookListException
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.feature.book.adapter.BookClickListener
import com.lucasfagundes.ioasysbooks.feature.book.adapter.BookListAdapter
import com.lucasfagundes.ioasysbooks.utils.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchBooksFragment : Fragment(), BookClickListener {

    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!
    private val viewModel: BookListViewModel by viewModel()
    private val adapter by lazy { BookListAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.booksListRecyclerView.adapter = adapter

        searchListener()
        recyclerViewScrollListener()
        addObserver()
    }

    private fun searchListener() {
        binding.searchCustomView.textChangeListener = { input ->
            viewModel.getBooks(input)
        }
    }

    private fun recyclerViewScrollListener() {
        with(binding) {
            booksListRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!booksListRecyclerView.canScrollVertically(1)) {
                        viewModel.getBooks(isNextPage = true)
                    }
                }
            })
        }
    }

    private fun addObserver() {
        viewModel.bookListLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success ->
                    handleSuccess(state.data)
                is ViewState.Error ->
                    handleError(state.throwable)
                else -> Unit
            }
        }
    }

    private fun handleSuccess(data: Pair<List<Book>, Boolean>) {
        with(binding){
            errorTextView.isVisible = false
            booksListRecyclerView.isVisible = true
        }
        adapter.apply {
            if (data.second) {
                viewModel.saveBooks(currentList + data.first)
                submitList(currentList + data.first)
            } else {
                viewModel.saveBooks(data.first)
                submitList(data.first)
            }
        }
    }

    private fun handleError(throwable: Throwable) {
        if (throwable is EmptyBookListException){
            with(binding){
                errorTextView.isVisible = true
                booksListRecyclerView.isVisible = false
            }
        }
    }

    override fun onBookClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager, "book")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}