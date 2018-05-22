package com.example.ebook.bookstore.presenters

import com.example.ebook.bookstore.models.Book

interface BookView {
    fun setBookList(books: List<Book>)
}