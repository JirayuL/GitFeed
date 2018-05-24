package com.example.gitfeed.jirayul.presenters

import com.example.gitfeed.jirayul.jirayul.Repo

interface GitFeedView {
    fun setBookList(repos: List<Repo>)
}