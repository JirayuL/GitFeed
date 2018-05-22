package com.example.ebook.bookstore.presenters

import com.example.ebook.bookstore.models.Book
import com.example.ebook.bookstore.models.BookRepository
import com.example.ebook.bookstore.models.FilterableBookRepository
import java.util.*

class BookPresenter(
        private val view: BookView,
        private val repository: BookRepository
) : Observer {

    fun start() {
        repository.addObserver(this)
        repository.loadAllBooks()
    }

    fun filter(newText: String) {
        if (repository is FilterableBookRepository) {
            view.setBookList(repository.filter(newText))
        }
    }

    override fun update(obj: Observable?, arg: Any?) {
        if(obj == repository) {
            // Update View
            view.setBookList(repository.getBooks())
        }
    }
}