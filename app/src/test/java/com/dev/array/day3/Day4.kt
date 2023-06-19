package com.dev.array.day3

import org.junit.Test

/** 查找第一个大于等于给定值的元素 */
class Day4 {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(3, 4, 6, 7, 10)

        // WHEN
        val result = getResult(array, 5)

        // THEN
        assert(2 == result)
    }

    fun getResult(array: IntArray, target: Int): Int {
        var low = 0
        var high = array.lastIndex
        while (low <= high) {
            val middle = low + ((high - low) shr 1)
            if (array[middle] >= target) {
                if (middle == 0 || array[middle - 1] < target) {
                    return middle
                } else {
                    high = middle - 1
                }
            } else {
                low = middle + 1
            }
        }
        return -1
    }
}