package com.example.gitfeed.jirayul.jirayul

class Repo(
        val full_name: String,
        val url: String,
        val description: String = ""
) {

    override fun toString(): String {
        return "${full_name} ${description}"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (this::class != other::class) return false
        val book = other as Repo
        return this.full_name.equals(book.full_name) &&
                this.url.equals(book.url) &&
                this.description.equals(book.description)
    }
}