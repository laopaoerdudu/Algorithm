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

    /**
    i = 0, array.lastIndex - i = 5

    i = 1, array.lastIndex - i = 4

    i = 2, array.lastIndex - i = 3

    i = 3, array.lastIndex - i = 2

    i = 4, array.lastIndex - i = 1

    i = 5, array.lastIndex - i = 0 */
    private fun bubbleSort(array: IntArray) {
        (0..array.lastIndex).forEach { i ->
            var isStop = false
            num++

            // 为什么是 scope = array.lastIndex - i?
            // 因为每一轮比较都可以把最大的扔后面，实现排序
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