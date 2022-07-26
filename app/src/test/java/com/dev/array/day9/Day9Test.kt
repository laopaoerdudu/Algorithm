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
        val size = array.size
        var non0point = 0
        var scanPoint = 0
        while (scanPoint < size) {
            // 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
            if (array[scanPoint] != 0) {
                // 每次交换，都是将左指针的零与右指针的非零数交换
                array[non0point] = array[scanPoint].also { array[scanPoint] = array[non0point] }
                non0point++
            }
            scanPoint++
        }
    }

    @Test
    fun test2() {
        // Given
        val array = intArrayOf(0, 1, 0, 3, 12)

        // When
        val result = solution2(array)

        // Then
        println(result.contentToString())
    }

    private fun solution2(array: IntArray): IntArray {
        val newArray = IntArray(array.size)
        var index = 0
        array.forEach { value ->
            if(value != 0) {
                newArray[index++] = value
            }
        }

        for(i in index..array.lastIndex) {
            newArray[i] = 0
        }

        return newArray
    }
}