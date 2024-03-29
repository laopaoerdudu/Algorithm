package com.dev.array.day5

import org.junit.Test

class Day5Test {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7)

        // WHEN
        rotate(array, 3)

        // THEN
        assert("[5, 6, 7, 1, 2, 3, 4]" == array.contentToString())
    }

    private fun rotate(array: IntArray, k: Int) {
        val size = array.size
        val newArray = IntArray(size)
        array.forEachIndexed { i, value ->
            newArray[(i + k) % size] = value
        }

        // 新数组的内容拷贝到旧数组
        System.arraycopy(newArray, 0, array, 0, size)
    }
}