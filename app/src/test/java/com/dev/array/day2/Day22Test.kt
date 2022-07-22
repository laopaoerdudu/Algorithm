package com.dev.array.day2

import org.junit.Test

// Ref: https://toutiao.io/posts/43slch7/preview
class Day22Test {

    @Test
    fun test() {
        // Given
        val array = intArrayOf(7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8)

        assert(12 == findKthLargest(array, 5))
    }

    private fun findKthLargest(array: IntArray, k: Int): Int {
        val targetIndex = array.size - k
        var low = 0
        var high = array.lastIndex

        // point 左边是小的数，右边是大的数
        // 假设求第5大的元素，那么 point 应该等于 7，如果 point = 10，那么 point 应该回退
        // 反之亦然
        while (true) {
            val point = partition(array, low, high)
            when {
                point < targetIndex -> low = point + 1
                point == targetIndex -> return array[point]
                else -> high = point - 1
            }
        }
    }

    /**
     * 分区函数，将 array[high] 作为 pivot 分区点
     */
    private fun partition(array: IntArray, low: Int, high: Int): Int {
        var point = low
        val pivot = array[high] // 拿最后的一个值做标杆

        // 这一轮下来比 pivot 小的值都找出来了，已经分好区了
        for (i in low until high) { // 和最后一个值之前的所有值挨个比较
            //println("i = $i, point = $point, array = ${array.contentToString()}")
            if (array[i] < pivot) {
                // 这里交换的目的是为了区分已处理区和非处理区，i 可能在arr[i]>pivot 的时候停下来
                array[i] = array[point].also { array[point] = array[i] } // i 的值换成比基准值小的
                point++ // 指针往前进一位，继续找
            }
        }
        println("point = $point, array = ${array.contentToString()}")
        array[high] = array[point].also { array[point] = array[high] }
        return point
    }
}