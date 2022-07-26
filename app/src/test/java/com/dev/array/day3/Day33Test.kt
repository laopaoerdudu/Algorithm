package com.dev.array.day3

import org.junit.Test

// 给定一个有序的数组，查找第一个等于给定 value 的数组下标，找不到返回 -1
class Day33Test {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(1, 2, 2, 2, 4)

        // WHEN
        val result = binarySearch(array, 2)

        // THEN
        assert(1 == result)
    }

    private fun binarySearch(array: IntArray, value: Int): Int {
        var low = 0
        var high = array.lastIndex

        while (low <= high) {
            val middle = low + ((high - low) shr 1) // 防止溢出，移位也更高效
            if(array[middle] >= value) {
                high = middle - 1
            } else {
                low = middle + 1
            }
        }

        if (low < array.size && array[low] == value) {
            return low
        }
        return -1
    }
}