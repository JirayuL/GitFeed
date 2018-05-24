package com.example.gitfeed.jirayul.jirayul


class InterestRepoRepository : FilterableRepoRepository() {

    override fun loadAllBooks() {
        repoList.clear()
//        repoList.add(Repo("hey","How to pass Softspec Course",90, 21))
//        repoList.add(Repo("yo","How to pass OOP2",100, 40))
//        repoList.add(Repo("wat","gimme an A",90, 500))
        setChanged()
        notifyObservers()
    }

    fun addBook(repo: Repo): Boolean {
        if (!repoList.contains(repo)) {
            repoList.add(repo)
            setChanged()
            notifyObservers()
            return true
        }
        return false
    }

}