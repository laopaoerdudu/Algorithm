package com.dev.array.day3

import org.junit.Test

// 查找最后一个等于给定 value 的数组下标
class Day333Test {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(1, 2, 2, 2, 4)

        // WHEN
        val result = binarySearch(array, 2)

        // THEN
        assert(3 == result)
    }

    private fun binarySearch(array: IntArray, value: Int): Int {
        var low = 0
        var hight = array.lastIndex

        while (low <= hight) {
            val middle = low + ((hight - low) shr 1) // 防止溢出，移位也更高效
            if(array[middle] > value) {
                hight = middle - 1
            } else {
                low = middle + 1
            }
        }

        if (hight >= 0 && array[hight] == value) {
            return hight
        }
        return -1
    }
}