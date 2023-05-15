package com.dev

class SampleBrowser(
    private var currentPage: String? = null,
    private var backStack: LinkedListStack = LinkedListStack(),
    private var forwardStack: LinkedListStack = LinkedListStack()
) {

    fun canGoBack(): Boolean {
        return this.backStack.size > 0
    }

    fun canGoForward(): Boolean {
        return this.forwardStack.size > 0
    }

    fun open(url: String) {
        if (this.currentPage != null) {
            this.backStack.push(this.currentPage)
            this.forwardStack.clear()
        }
        showUrl(url, "Open")
    }

    fun goBack(): String? {
        if (this.canGoBack()) {
            this.forwardStack.push(currentPage)
            val backUrl = this.backStack.pop()
            showUrl(backUrl, "Back")
            return backUrl
        }
        println("Cannot go back, no pages behind.")
        return null
    }

    fun goForward(): String? {
        if (this.canGoForward()) {
            this.backStack.push(this.currentPage)
            val forwardUrl = this.forwardStack.pop()
            showUrl(forwardUrl, "Forward")
            return forwardUrl
        }
        println("Cannot go forward, no pages ahead.")
        return null
    }

    fun showUrl(url: String?, prefix: String) {
        this.currentPage = url
        println("$prefix to $url")
    }
}