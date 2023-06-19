package com.dev.array.day3

import org.junit.Test

/** 查找最后一个小于等于给定值的元素 */
class Day5Test {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(3, 5, 6, 8, 9, 10)

        // WHEN
        val result = getResult(array, 7)

        // THEN
        assert(2 == result)
    }

    private fun getResult(array: IntArray, target: Int): Int {
        var low = 0
        var high = array.lastIndex
        while (low <= high) {
            val middle = low + ((high - low) shr 1)
            if (array[middle] > target) {
                high = middle - 1
            } else {
                if (middle == array.lastIndex || array[middle + 1] > target) {
                    return middle
                } else {
                    low = middle + 1
                }
            }
        }
        return -1
    }
}