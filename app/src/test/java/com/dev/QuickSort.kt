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
        var pivot = head

        // After this round of forEach, we can get pivot
        (head until tail).forEach { i ->
            if (array[i] < array[tail]) {
                if (pivot != i) {
                    array[pivot] = array[i].also { array[i] = array[pivot] }
                }
                pivot++
            }
        }
        array[pivot] = array[tail].also { array[tail] = array[pivot] }
        return pivot
    }
}