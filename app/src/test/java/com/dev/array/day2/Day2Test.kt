package com.dev.array.day2

import org.junit.Test

// Ref: https://toutiao.io/posts/43slch7/preview
class Day2Test {

    @Test
    fun test() {
        // Given
        val array = intArrayOf(7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8)

        assert(12 == findKthLargest(array, 5))
    }

    private fun findKthLargest(array: IntArray, k: Int): Int {
       return 1
    }

    private fun getPartitionIndex(array: IntArray, low: Int, high: Int): Int {
        return 1
    }
}