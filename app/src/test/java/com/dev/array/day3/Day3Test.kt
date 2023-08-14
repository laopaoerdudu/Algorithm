package com.dev.array.day3

import org.junit.Test

class Day3Test {

    @Test
    fun test() {
        val array = intArrayOf(24, 20, 17, 15, 12, 9, 8, 7, 5, 3, 2, 1) // intArrayOf(1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 20, 24)
        //assert(4 == binarySearch(array, 7))
        println("result -> ${binarySearch(array, 7)}")
    }

    private fun binarySearch(array: IntArray, value: Int): Int {
        var low = 0
        var high = array.lastIndex

        while (low <= high) {
            val middle = low + ((high - low) shr 1) // 防止溢出，移位也更高效
            when {
                array[middle] > value -> {
                    high = middle - 1
                }

                array[middle] == value -> {
                    return middle
                }

                else -> {
                    low = middle + 1
                }
            }
        }
        return -1
    }
}