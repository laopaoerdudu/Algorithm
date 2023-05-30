package com.dev

import org.junit.Assert.assertEquals
import org.junit.Test

class BubbleSortTest {
    private var num = 0

    @Test
    fun test() {
        // GIVEN
        var array = intArrayOf(3, 5, 4, 1, 2, 6)

        // WHEN
        bubbleSort(array)

        // THEN
        assertEquals("1, 2, 3, 4, 5, 6", array.joinToString())
        assertEquals(4, num)
    }

    private fun bubbleSort(array: IntArray) {
        (0..array.lastIndex).forEach { i ->
            var isStop = false
            num++
            (0 until array.lastIndex - i).forEach { j ->
                if (array[j] > array[j + 1]) {
                    array[j] = array[j + 1].also {
                        array[j + 1] = array[j]
                        isStop = true
                    }
                }
            }
            if (isStop.not()) {
                return
            }
        }
    }
}