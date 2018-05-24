package com.example.gitfeed.jirayul.jirayul

class MockRepoRepository : FilterableRepoRepository() {

    override fun loadAllBooks() {
        repoList.clear()
        repoList.add(Repo("Gear","aaaa","a student"))
        repoList.add(Repo("Jim","bbbb","a god"))
        repoList.add(Repo("Jittat","cccc","a god too"))
        setChanged()
        notifyObservers()
    }

}