package com.dev.array.day10

import org.junit.Test

class Day10Test {

    @Test
    fun test() {
        // Given
        val array = intArrayOf(2, 7, 11, 15)
        val target = 9

        // When
        val result = solution1(array, target)

        // Then
        println(result.contentToString())
    }

    private fun solution1(array: IntArray, target: Int): IntArray {
        for(i in 0..array.lastIndex) {
            for(j in (i+1)..array.lastIndex) {
                if (array[i] + array[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return IntArray(2)
    }
}