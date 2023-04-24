package com.dev

import org.junit.Test

/** 反转字符串 */
class Day4Test {

    @Test
    fun test() {
        // GIVEN
        val data: Array<Char> = arrayOf('h', 'e', 'l', 'l', 'o')

        // WHEN
        reverseString(data)

        // THEN
        println(data.joinToString())
    }

    private fun reverseString(data: Array<Char>) {
        var left = 0
        var right = data.lastIndex
        while (left < right) {
            val temp = data[left]
            data[left] = data[right]
            data[right] = temp
            ++left
            --right
        }
    }
}