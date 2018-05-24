package com.example.gitfeed.jirayul

import com.example.gitfeed.jirayul.jirayul.RepoRepository
import com.example.gitfeed.jirayul.presenters.GitFeedPresenter
import com.example.gitfeed.jirayul.presenters.GitFeedView
import org.junit.Test
import org.junit.Before
import org.mockito.Mockito.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var view = mock(GitFeedView :: class.java)
    var repo = mock(RepoRepository :: class.java)
    var presenter = GitFeedPresenter(view, repo)
    var inOrder = inOrder(repo)
    var inOrder2 = inOrder(view)

    @Before
    fun init(){
        view = mock(GitFeedView :: class.java)
        repo = mock(RepoRepository :: class.java)
        presenter = GitFeedPresenter(view, repo)
        inOrder = inOrder(repo)
        inOrder2 = inOrder(view)
    }

    @Test
    fun testStart() {
        presenter.start()
        inOrder.verify(repo).addObserver(presenter)
    }
}
