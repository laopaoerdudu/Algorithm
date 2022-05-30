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
        // 数字加法应该从最后一位开始，所以我们从数组末尾向前遍历
        for (i in array.lastIndex downTo 0) {
            if (array[i] != 9) {
                ++array[i] // 直接加1
                for (j in i + 1..array.lastIndex) {
                    array[j] = 0
                }
                return array
            }
        }

        // array 中所有的元素均为 9
        return IntArray(array.size + 1).apply {
            this[0] = 1
        }
    }
}