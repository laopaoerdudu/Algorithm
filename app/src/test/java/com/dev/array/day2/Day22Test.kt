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

        while (true) {
            val i = partition(array, low, high)
            when {
                i < targetIndex -> low = i + 1
                i == targetIndex -> return array[i]
                else -> high = i - 1
            }
        }
    }

    /**
     * 分区函数，将 array[high] 作为 pivot 分区点
     * i、j 两个指针，i 作为标记 `已处理区间` 和 `未处理区间` 的分界点，也即 i 左边的（low ~ i-1）都是 `已处理区`。
     * j 指针遍历数组，当 array[j] 小于 pivot 时，就把 array[j] 放到 `已处理区间` 的尾部，也即是 array[i] 所在位置。
     * 因此 swap(arr, i, j) 然后 i 指针后移，i++
     * 直到 j 遍历到数组末尾 array[high]，将 array[i] 和 arr[high]（pivot点） 进行交换，返回下标 i，就是分区点的下标。
     * */
    private fun partition(array: IntArray, low: Int, high: Int): Int {
        var i = low
        val pivot = array[high] // 拿最后的一个值做标杆

        // 这一轮下来比 pivot 小的值都找出来了，已经分好区了
        for (j in low until high) { // 和最后一个值之前的所有值挨个比较
            if (array[j] < pivot) {
                // 这里交换的目的是为了区分已处理区和非处理区，i 可能在arr[j]>pivot 的时候停下来，而j还在不停改变；
                array[j] = array[i].also { array[i] = array[j] } // i 的值换成比基准值小的
                i++ // i 指针往前进一位，继续找
            }
        }
        array[high] = array[i].also { array[i] = array[high] }
        return i
    }
}