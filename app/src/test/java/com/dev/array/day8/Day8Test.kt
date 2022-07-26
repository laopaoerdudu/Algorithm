package com.dev.array.day8

import org.junit.Test

class Day8Test {

    @Test
    fun test1() {
        // Given
        val array = intArrayOf(1, 2, 3)

        // Then
        assert("[1, 2, 4]" == plusOne(array).contentToString())
    }

    @Test
    fun test2() {
        // Given
        val array = intArrayOf(1, 2, 3, 9, 9)

        // Then
        assert("[1, 2, 4, 0, 0]" == plusOne(array).contentToString())
    }

    @Test
    fun test3() {
        // Given
        val array = intArrayOf(9, 9, 9, 9, 9)

        // Then
        assert("[1, 0, 0, 0, 0, 0]" == plusOne(array).contentToString())
    }

    private fun plusOne(array: IntArray): IntArray {
        return IntArray(2)
    }
}