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
        // 这是一个优化细节，检查数组大小并对较小的数组进行哈希映射
        // 这样可以降低空间复杂度
        if (array1.size > array2.size) {
            return intersect(array2, array1)
        }

        val map = mutableMapOf<Int, Int>()
        array1.forEach { value ->
            map[value] = map.getOrDefault(value, 0) + 1
        }

        // 拿长度小的数组，降低空间复杂度
        val intersectionArray = IntArray(array1.size)
        var index = 0
        array2.forEach { value ->
            var count = map.getOrDefault(value, 0)
            if (count > 0) {
                intersectionArray[index++] = value
                count--
                if (count > 0) {
                    map[value] = count
                } else {
                    map.remove(value)
                }
            }
        }
        return intersectionArray.copyOfRange(0, index)
    }
}