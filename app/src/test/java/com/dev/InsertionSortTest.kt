package com.dev

import org.junit.Assert.assertEquals
import org.junit.Test

class InsertionSortTest {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(4, 5, 6, 1, 3, 2)

        // WHEN
        insertSort(array)

        // THEN
        assertEquals("1, 2, 3, 4, 5, 6", array.joinToString())
    }

    private fun insertSort(array: IntArray) {
        // 从下标为1开始，左边为已排序，右边为待排序
        (1..array.lastIndex).forEach { i ->
            (i downTo 1).forEach { j ->
                if (array[j] < array[j - 1]) {
                    array[j] = array[j - 1].also { array[j - 1] = array[j] }
                }
            }
        }
    }
}