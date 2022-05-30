package com.dev.array.day3

import org.junit.Test

// 给定一个有序的数组，查找第一个等于给定 value 的数组下标，找不到返回 -1
class Day33Test {

    @Test
    fun test() {
        // GIVEN
        val array = arrayOf(1, 2, 2, 2, 4)

        // WHEN
        val result = binarySearch(array, 2)

        // THEN
        assert(1 == result)
    }

    private fun binarySearch(array: Array<Int>, value: Int): Int {
        var left = 0
        var right = array.lastIndex

        while (left <= right) {
            val middle = left + ((right - left) shr 1) // 防止溢出，移位也更高效
            if(array[middle] >= value) {
                right = middle - 1
            } else {
                left = middle + 1
            }
        }

        if (left < array.size && array[left] == value) {
            return left
        }

        return -1
    }
}