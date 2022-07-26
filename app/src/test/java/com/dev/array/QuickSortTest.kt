package com.dev.array

import org.junit.Test

class QuickSortTest {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8)

        // WHEN
        quickSort(array, 0, array.lastIndex)

        // THEN
        assert("[1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 20, 24]" == array.contentToString())
    }

    private fun quickSort(array: IntArray, leftIndex: Int, rightIndex: Int) {

    }

    private fun partition(array: IntArray, leftIndex: Int, rightIndex: Int): Int {
        return -1
    }
}