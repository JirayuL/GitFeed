package com.example.gitfeed.jirayul.jirayul

import java.util.*
import kotlin.collections.ArrayList

abstract class RepoRepository : Observable() {
    abstract fun loadAllBooks()
    abstract fun getBooks(): ArrayList<Repo>
}