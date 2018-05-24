package com.example.gitfeed.jirayul.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.gitfeed.jirayul.jirayul.Repo


class TwoLineArrayAdapter(
        ctx: Context,
        val repos: ArrayList<Repo>
) : ArrayAdapter<Repo>(
        ctx,
        android.R.layout.simple_list_item_2,
        android.R.id.text1,
        repos
) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = super.getView(position, convertView, parent)
        val text1: TextView = view.findViewById(android.R.id.text1)
        val text2: TextView = view.findViewById(android.R.id.text2)
        val repo: Repo = repos.get(position)
        text1.text = repo.full_name
        text2.text = repo.description
        print(text1.text)
        print(text2.text)
        return view
    }
}