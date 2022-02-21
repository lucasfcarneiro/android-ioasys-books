package com.lucasfagundes.ioasysbooks.feature.book.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lucasfagundes.ioasysbooks.R
import com.lucasfagundes.ioasysbooks.databinding.ItemBookBinding
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.utils.DefaultDiffCallback

class BookListAdapter(private val onBookClickListener: BookClickListener) :
    ListAdapter<Book, BookListAdapter.BookListViewHolder>(DefaultDiffCallback<Book>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        return BookListViewHolder.create(parent, onBookClickListener)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BookListViewHolder(
        private val binding: ItemBookBinding,
        private val onBookClickListener: BookClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.apply {
                bookTitleTextView.text = book.title
                bookAuthorTextView.text = book.author
                bookPagesTextView.text = book.pages
                bookPublisherTextView.text = book.publisher
                bookPublicationDateTextView.text = book.publicationDate
                bookImageView.load(book.imageUrl){
                    error(R.drawable.small_book)
                }

                root.setOnClickListener {
                    onBookClickListener.onBookClickListener(book)
                }
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onBookClickListener: BookClickListener
            ): BookListViewHolder {
                val binding = ItemBookBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BookListViewHolder(binding, onBookClickListener)
            }
        }
    }
}