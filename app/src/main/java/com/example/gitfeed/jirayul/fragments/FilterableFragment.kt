package com.example.gitfeed.jirayul.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.example.gitfeed.jirayul.R
import com.example.gitfeed.jirayul.adapters.TwoLineArrayAdapter
import com.example.gitfeed.jirayul.jirayul.Repo
import com.example.gitfeed.jirayul.presenters.GitFeedView
import kotlinx.android.synthetic.main.fragment_book_list.view.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val TAB_NUMBER = "tabNumber"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FilterableFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FilterableFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FilterableFragment : Fragment(), GitFeedView {

    private var repoAdapter: ArrayAdapter<Repo>? = null
    private var tabNumber: Int? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tabNumber = it.getInt(TAB_NUMBER)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_book_list, container, false)
        repoAdapter = TwoLineArrayAdapter(rootView.context, ArrayList())
        rootView.bookListView.adapter = repoAdapter
        rootView.bookListView.setOnItemClickListener { parent, view, position, id ->
            listener?.onListItemClicked(tabNumber!!, position)
        }
        listener?.onFragmentCreated(tabNumber!!)
        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun setBookList(repos: List<Repo>) {
        repoAdapter?.clear()
        repoAdapter?.addAll(repos)
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentCreated(tabNumber: Int)
        fun onListItemClicked(tabNumber: Int, position: Int)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param tabNumber Tab's unique number.
         * @return A new instance of fragment FilterableFragment.
         */
        @JvmStatic
        fun newInstance(tabNumber: Int) =
                FilterableFragment().apply {
                    arguments = Bundle().apply {
                        putInt(TAB_NUMBER, tabNumber)
                    }
                }
    }
}
