package com.example.ebook.bookstore.models

class MockBookRepository : FilterableBookRepository() {

    override fun loadAllBooks() {
        bookList.clear()
        bookList.add(Book(1,"Jittat forever",19.99))
        bookList.add(Book(2,"Dank meme 101",15.99))
        setChanged()
        notifyObservers()
    }

}