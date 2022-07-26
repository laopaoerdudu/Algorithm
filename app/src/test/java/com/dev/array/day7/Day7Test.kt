package com.dev.array.day7

import org.junit.Test

class Day7Test {

    @Test
    fun test() {
        // Given
        val array1 = intArrayOf(4, 9, 5, 4, 4, 7)
        val array2 = intArrayOf(9, 4, 9, 8, 4)

        // Then
        assert("[4, 9, 4]" == intersect(array1, array2).contentToString())
    }

    private fun intersect(array1: IntArray, array2: IntArray): IntArray {
        return IntArray(2)
    }
}