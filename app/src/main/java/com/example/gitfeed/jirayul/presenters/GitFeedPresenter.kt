package com.example.gitfeed.jirayul.presenters

import com.example.gitfeed.jirayul.jirayul.RepoRepository
import com.example.gitfeed.jirayul.jirayul.FilterableRepoRepository
import java.util.*

class GitFeedPresenter(
        private val view: GitFeedView,
        private val repository: RepoRepository
) : Observer {

    fun start() {
        repository.addObserver(this)
        repository.loadAllBooks()
    }

    fun filter(newText: String) {
        if (repository is FilterableRepoRepository) {
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