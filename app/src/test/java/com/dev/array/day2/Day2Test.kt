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
        // 利用快排分区，小的数在左边，大的数在右边
        var low = 0
        var high = array.lastIndex
        val target = array.size - k
        while (true) {
            val partition = getPartitionIndex(array, low, high)
            when {
                partition < target -> low = partition + 1
                partition == target -> return array[partition]
                else -> high = partition - 1
            }
        }
    }

    private fun getPartitionIndex(array: IntArray, low: Int, high: Int): Int {
        var point = low
        val pivot = array[high]
        for (i in low until high) {
            if(array[i] < pivot) {
                array[point] = array[i].also { array[i] = array[point] }
                point++
            }
        }
        array[point] = array[high].also { array[high] = array[point] }
        return point
    }
}