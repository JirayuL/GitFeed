package com.example.ebook.bookstore.models


class MyBookRepository : FilterableBookRepository() {

    override fun loadAllBooks() {
        bookList.clear()
        bookList.add(Book(1,"How to pass Softspec Course",15.99))
        bookList.add(Book(2,"How to pass OOP2",19.99))
        bookList.add(Book(5,"gimme an A",299.99))
        setChanged()
        notifyObservers()
    }

    fun addBook(book: Book): Boolean {
        if (!bookList.contains(book)) {
            bookList.add(book)
            setChanged()
            notifyObservers()
            return true
        }
        return false
    }

}