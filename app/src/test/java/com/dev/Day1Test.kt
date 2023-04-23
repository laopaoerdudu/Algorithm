package com.dev

import org.junit.Test

/** 如何判断一个字符串是否是回文字符串的问题？ */
class Day1Test {

    @Test
    fun test() {

    }

    private fun isPalindromicSubstring(data: String): Boolean {
        val size = data.length
        (0 until size / 2).forEach { i ->
            if (data[i] != data[size - i - 1]) {
                return false
            }
        }
        return true
    }
}