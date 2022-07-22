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

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * */
    private fun bestPractice(array: IntArray): Int {
        var current = 0
        var votes = 0

        array.forEach { value ->
            // 遇到相同的数，votes +1，遇到不同的数，votes -1
            if (votes == 0) {
                current = value
            }
            votes += (if (current == value) 1 else -1)
        }
        return current
    }

    private fun solution(array: IntArray): Int {
        var count = 0
        val quit = array.size shr 1
        for (i in 0..array.lastIndex) {
            for (j in (i + 1)..array.lastIndex) {
                if (array[j] == array[i]) {
                    if (count >= quit) {
                        return array[j]
                    }
                    count++
                }
            }
        }
        return -1
    }

    private fun getResult(array: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        array.forEach { item ->
            if (!map.containsKey(item)) {
                map[item] = 1
            } else {
                map[item] = (map[item] as Int) + 1
            }
        }

        for ((key, value) in map) {
            if (value > (array.size shr 1)) {
                return key
            }
        }
        return 0
    }
}