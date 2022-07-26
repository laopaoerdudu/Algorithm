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

        return -1
    }
}