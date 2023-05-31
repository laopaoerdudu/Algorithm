package com.dev

import org.junit.Assert.assertEquals
import org.junit.Test

class SelectSortTest {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(35, 9, 15, 33, 40, 22, 45, 25, 44, 43, 3)

        // WHEN
        selectSort(array)

        // THEN
        assertEquals("3, 9, 15, 22, 25, 33, 35, 40, 43, 44, 45", array.joinToString())
    }

    private fun selectSort(array: IntArray) {
        (0..array.lastIndex).forEach { i ->
            var min = i
            (i + 1..array.lastIndex).forEach { j ->
                if (array[j] < array[min]) {
                    min = j
                }
            }
            if (i != min) {
                array[i] = array[min].also {
                    array[min] = array[i]
                }
            }
        }
    }
}