package com.dev.array.day3

import org.junit.Test

class Day3Test {

    @Test
    fun test() {
        val array = intArrayOf(1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 20, 24)
        assert(4 == binarySearch(array, 7))
    }

    private fun binarySearch(array: IntArray, value: Int): Int {

        return -1
    }
}