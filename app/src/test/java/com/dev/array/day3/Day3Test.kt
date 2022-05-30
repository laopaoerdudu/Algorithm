package com.dev.array.day3

import org.junit.Test

class Day3Test {

    @Test
    fun test() {
        val array = arrayOf(1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 20, 24)
        assert(4 == binarySearch(array, 7))
    }

    private fun binarySearch(array: Array<Int>, value: Int): Int {
        var left = 0
        var right = array.lastIndex

        while (left <= right) {
            val middle = left + ((right - left) shr 1) // 防止溢出，移位也更高效
            when {
                array[middle] > value -> {
                    right = middle - 1
                }

                array[middle] == value -> {
                    return middle
                }

                else -> {
                    left = middle + 1
                }
            }
        }
        return -1
    }
}