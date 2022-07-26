package com.dev.array.day1

import org.junit.Test

class Day1Test {

    @Test
    fun test() {
        // Given
        val array = intArrayOf(1, 2, 3, 2, 2, 2, 5, 2, 4)

        // When
        val result = getResult(array)

        // Then
        assert(2 == result)
    }

    private fun solution(array: IntArray): Int {
        return -1
    }

    private fun getResult(array: IntArray): Int {
        return 0
    }
}