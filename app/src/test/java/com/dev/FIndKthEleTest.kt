package com.dev

import org.junit.Assert.assertEquals
import org.junit.Test

/** 如何用快排思想在 O(n)内查找第 K 大元素？ */
class FIndKthEleTest {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(5, 3, 1, 2, 6, 9, 12, 10)

        // WHEN
        val result = findKthLargest(array, 4)

        // THEN
        assert(6 == result)
    }

    private fun findKthLargest(array: IntArray, kIndex: Int): Int {
        // 第 k 大元素的索引是 array.size - kIndex
        val target = array.size - kIndex
        var head = 0
        var tail = array.lastIndex
        while (true) {
            val pivot = partition(array, head, tail)
            when {
                target == pivot -> return array[pivot]
                target < pivot -> tail = pivot - 1
                else -> {
                    head = pivot + 1
                }
            }
        }
        return -1
    }

    private fun partition(array: IntArray, head: Int, tail: Int): Int {
        var pivot = head
        (head until tail).forEach { i ->
            if (array[i] < array[tail]) {
                if (i != pivot) {
                    array[pivot] = array[i].also { array[i] = array[pivot] }
                }
                pivot++
            }
        }
        array[pivot] = array[tail].also { array[tail] = array[pivot] }
        return pivot
    }
}