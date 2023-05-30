package com.dev

import org.junit.Assert.assertEquals
import org.junit.Test

class BubbleSortTest {
    private var num = 0

    @Test
    fun test() {
        // GIVEN
        var array = intArrayOf(32, 45, 20, 1, 44, 26, 9, 3, 34, 27, 21)

        // WHEN
        bubbleSort(array)

        // THEN
        assertEquals("1, 3, 9, 20, 21, 26, 27, 32, 34, 44, 45", array.joinToString())
        // assertEquals(5, num)
        println("num: $num")
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