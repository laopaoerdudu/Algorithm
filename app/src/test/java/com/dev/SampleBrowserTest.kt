package com.dev

import org.junit.Test

class SampleBrowserTest {

    @Test
    fun test() {
        // GIVEN
        val browser = SampleBrowser()
        browser.open("http://www.baidu.com")
        browser.open("http://news.baidu.com/")
        browser.open("http://news.baidu.com/ent")

        // WHEN
        browser.goBack()

        // THEN
    }
}