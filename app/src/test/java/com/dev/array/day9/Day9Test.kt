package com.dev.array.day9

import org.junit.Test

class Day9Test {

    @Test
    fun test() {
        // Given
        val array = intArrayOf(0, 1, 0, 3, 12)

        // When
        moveZeroes(array)

        // Then
        assert("[1, 3, 12, 0, 0]" == array.contentToString())
    }

    private fun moveZeroes(array: IntArray) {

    }

    @Test
    fun test2() {
        // Given
        val array = intArrayOf(0, 1, 0, 3, 12)

        // When
        val result = solution(array)

        // Then
        println(result.contentToString())
    }

    private fun solution(array: IntArray): IntArray {
        return IntArray(2)
    }
}