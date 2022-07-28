package com.dev.string.day1

import org.junit.Test

class Day1Test {

    @Test
    fun test() {
        // GIVEN
        val array = charArrayOf('h', 'e', 'l', 'l', 'o')

        // WHEN
        val result = reverseString(array)

        // THEN
        assert("[o, l, l, e, h]" == result.contentToString())
    }

    private fun reverseString(array: CharArray): CharArray {
        var left = 0
        var right = array.lastIndex
        while (left < right) {
            array[left] = array[right].also { array[right] = array[left] }
            left++
            right--
        }
        return array
    }
}