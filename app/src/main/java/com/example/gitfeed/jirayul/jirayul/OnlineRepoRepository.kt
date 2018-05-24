package com.example.gitfeed.jirayul.jirayul

import android.annotation.SuppressLint
import android.os.AsyncTask
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import java.util.ArrayList

class OnlineRepoRepository : FilterableRepoRepository() {

    override fun loadAllBooks() {
        val url = URL("https://api.github.com/repositories")
        val loadDataFromURL = URLDownloadTask()
        loadDataFromURL.execute(url)
    }

    @SuppressLint("StaticFieldLeak")
    private inner class URLDownloadTask : AsyncTask<URL, Void, ArrayList<Repo>>() {
        override fun doInBackground(vararg params: URL): ArrayList<Repo>? {
            val repos: ArrayList<Repo> = ArrayList()
            try {
                val url: URL = params[0]
                val response: String = url.readText()
                val jsonArray = JSONArray(response)
                for (index: Int in 0..jsonArray.length() - 1) {
                    val jsonBook: JSONObject = jsonArray.getJSONObject(index)
                    try {
                        repos.add(Repo(
                                jsonBook.get("full_name") as String,
                                jsonBook.get("url") as String,
                                jsonBook.get("description") as String
                        ))
                    } catch (e: Exception){
                        repos.add(Repo(
                                jsonBook.get("full_name") as String,
                                jsonBook.get("url") as String,
                                jsonBook.get("") as String
                        ))
                    }

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return repos
        }

        override fun onPostExecute(result: ArrayList<Repo>) {
            repoList.clear()
            repoList.addAll(result)
            setChanged()
            notifyObservers()
        }
    }
}