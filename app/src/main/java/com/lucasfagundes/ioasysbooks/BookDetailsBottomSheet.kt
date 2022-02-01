package com.lucasfagundes.ioasysbooks

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lucasfagundes.ioasysbooks.databinding.FragmentBookDetailsBottomSheetBinding
import com.lucasfagundes.ioasysbooks.feature.login.model.Book

class BookDetailsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentBookDetailsBottomSheetBinding? = null
    private val binding: FragmentBookDetailsBottomSheetBinding get() = _binding!!

    private var book: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =  FragmentBookDetailsBottomSheetBinding.inflate(inflater,container,false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setListeners()
        setupBottomSheetHeight()
    }

    private fun setupBottomSheetHeight() {
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun setListeners() {
        binding.closeButton.setOnClickListener{
            dismiss()
        }
    }

    private fun setupView() {
        binding.apply {

            resultBookTitleTV.text = book?.title
            resultOriginalTitleTV.text = book?.title
            resultAuthorTV.text = book?.author
            resultPagesTV.text = book?.pages
            resultPublisherTV.text = book?.publisher
            resultPublicationDateTV.text = book?.publicationDate
            resultLanguageTV.text = book?.language
            resultOriginalTitleTV.text = book?.title
            resultISBN10TV.text = book?.isbn10
            resultISBN13TV.text = book?.isbn13

            val spannableString = SpannableString("   ${book?.review}")
            val imageSpan = ImageSpan(requireContext(),R.drawable.ic_quotes)
            spannableString.setSpan(imageSpan,0,1, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
            resultReviewFromPublisherTV.text = spannableString
        }
    }

    companion object{
        fun newInstance(book: Book? = null): BookDetailsBottomSheet{
            return BookDetailsBottomSheet().apply {
                this.book = book
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}