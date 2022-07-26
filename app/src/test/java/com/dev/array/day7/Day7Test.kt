package com.dev.array.day7

import org.junit.Test

class Day7Test {

    @Test
    fun test() {
        // Given
        val array1 = intArrayOf(4, 9, 5, 4, 4, 7)
        val array2 = intArrayOf(9, 4, 9, 8, 4)

        // Then
        assert("[4, 9, 4]" == intersect(array1, array2).contentToString())
    }

    private fun intersect(array1: IntArray, array2: IntArray): IntArray {
        if(array1.size > array2.size) {
            return intersect(array2, array1)
        }

        var index = 0
        var newArray = IntArray(array1.size)
        val map = mutableMapOf<Int, Int>()

        array1.forEach { value ->
            map[value] = map.getOrDefault(value, 0) + 1
        }

        array2.forEach { value ->
            var count = map.getOrDefault(value, 0)
            if(count > 0) {
                newArray[index++] = value
                count--
                if (count > 0) {
                    map[value] = count
                } else {
                    map.remove(value)
                }
            }
        }

        return newArray.copyOfRange(0, index)
    }
}