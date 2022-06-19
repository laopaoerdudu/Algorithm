package com.dev.array

import org.junit.Test

// 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
// 针对所有的元素重复以上的步骤，除了最后一个。
// 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
class BubbleSortTest {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(38, 18, 23, 4, 5, 47, 39, 3, 8, 15)

        // WHEN
        bubbleSort(array)

        // THEN
        assert("[3, 4, 5, 8, 15, 18, 23, 38, 39, 47]" == array.contentToString())
    }

    private fun bubbleSort(array: IntArray) {
        var needChange: Boolean
        for (i in 1..array.lastIndex) {
            needChange = false

            for (j in 0..(array.lastIndex - i)) {
                if (array[j] > array[j + 1]) {
                    array[j + 1] = array[j].also { array[j] = array[j + 1] }
                    needChange = true
                }
            }

            if (!needChange) {
                break
            }
        }
    }
}