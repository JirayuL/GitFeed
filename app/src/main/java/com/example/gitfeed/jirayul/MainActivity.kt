package com.example.gitfeed.jirayul

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import com.example.gitfeed.jirayul.adapters.TabPagerAdapter
import com.example.gitfeed.jirayul.fragments.FilterableFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.example.gitfeed.jirayul.jirayul.RepoRepository
import com.example.gitfeed.jirayul.jirayul.InterestRepoRepository
import com.example.gitfeed.jirayul.jirayul.OnlineRepoRepository
import com.example.gitfeed.jirayul.presenters.GitFeedPresenter


class MainActivity : AppCompatActivity(), FilterableFragment.OnFragmentInteractionListener {

    companion object {
        private val BOOKLIST_TAB = 0
        private val MYBOOK_TAB = 1
    }

    private lateinit var repoListRepository: RepoRepository // Model
    private lateinit var bookListFragment: FilterableFragment // View
    private lateinit var gitFeedListPresenter: GitFeedPresenter // Presenter

    private lateinit var interestRepoRepository: InterestRepoRepository // Model
    private lateinit var myBookFragment: FilterableFragment // View
    private lateinit var myGitFeedPresenter: GitFeedPresenter // Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        configureModel()
        configureTabLayout()
    }

    override fun onFragmentCreated(tabNumber: Int) {
        when (tabNumber) {
            BOOKLIST_TAB -> gitFeedListPresenter.start()
            MYBOOK_TAB -> myGitFeedPresenter.start()
        }
    }

    override fun onListItemClicked(tabNumber: Int, position: Int) {
        when (tabNumber) {
            BOOKLIST_TAB -> {
                interestRepoRepository.addBook(repoListRepository.getBooks().get(position))
            }
            MYBOOK_TAB -> {
            }
        }
    }

    private fun configureModel() {
        repoListRepository = OnlineRepoRepository() // Model
        bookListFragment = FilterableFragment.newInstance(BOOKLIST_TAB) // View
        gitFeedListPresenter = GitFeedPresenter(bookListFragment, repoListRepository) // Presenter

        interestRepoRepository = InterestRepoRepository() // Model
        myBookFragment = FilterableFragment.newInstance(MYBOOK_TAB) // View
        myGitFeedPresenter = GitFeedPresenter(myBookFragment, interestRepoRepository) // Presenter
    }

    private fun configureTabLayout() {
        pager.adapter = TabPagerAdapter(
                supportFragmentManager,
                tabs.tabCount,
                bookListFragment,
                myBookFragment
        )

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.search_book_button)
        val searchView: SearchView = searchItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    gitFeedListPresenter.filter(newText)
                    myGitFeedPresenter.filter(newText)
                }
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }
}