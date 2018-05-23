package com.example.ebook.bookstore

import com.example.ebook.bookstore.models.BookRepository
import com.example.ebook.bookstore.presenters.BookPresenter
import com.example.ebook.bookstore.presenters.BookView
import org.junit.Test
import org.junit.Before
import org.mockito.Mockito.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var view = mock(BookView :: class.java)
    var repo = mock(BookRepository :: class.java)
    var presenter = BookPresenter(view, repo)
    var inOrder = inOrder(repo)
    var inOrder2 = inOrder(view)

    @Before
    fun init(){
        view = mock(BookView :: class.java)
        repo = mock(BookRepository :: class.java)
        presenter = BookPresenter(view, repo)
        inOrder = inOrder(repo)
        inOrder2 = inOrder(view)
    }

    @Test
    fun testStart() {
        presenter.start()
        inOrder.verify(repo).addObserver(presenter)
    }
}
