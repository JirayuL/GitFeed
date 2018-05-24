package com.example.gitfeed.jirayul.jirayul

abstract class FilterableRepoRepository : RepoRepository() {

    protected val repoList: ArrayList<Repo> = ArrayList()

    override fun getBooks(): ArrayList<Repo> {
        return repoList
    }

    fun filter(keyword: String): List<Repo> {
        return repoList.filter({ repo: Repo ->
            repo.full_name.contains(keyword, true) || repo.description.toString().contains(keyword, true)
        })

    }
}