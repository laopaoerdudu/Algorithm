package com.dev

import org.junit.Assert.assertEquals
import org.junit.Test

class QuickSort {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(35, 9, 15, 33, 40, 22, 45, 25, 44, 43, 3)

        // WHEN
        quickSort(array, 0, array.lastIndex)

        // THEN
        assertEquals("3, 9, 15, 22, 25, 33, 35, 40, 43, 44, 45", array.joinToString())
    }

    private fun quickSort(array: IntArray, head: Int, tail: Int) {
        if (head >= tail) {
            return
        }
        val pivot = getPartition(array, head, tail)
        quickSort(array, head, pivot - 1)
        quickSort(array, pivot + 1, tail)
    }

    private fun getPartition(array: IntArray, head: Int, tail: Int): Int {
        var pivot = array[tail]
        var point = head
        (head until tail).forEach { i ->
            if (array[i] < pivot) {
                if (point != i) {
                    array[point] = array[i].also { array[i] = array[point] }
                }
                point++
            }
        }
        array[point] = array[tail].also { array[tail] = array[point] }
        return point
    }
}