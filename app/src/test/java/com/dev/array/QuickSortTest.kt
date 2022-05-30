package com.dev.array

import org.junit.Test

class QuickSortTest {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8)

        // WHEN
        quickSort(array, 0, array.lastIndex)

        // THEN
        assert("[1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 20, 24]" == array.contentToString())
    }

    /**
     * 「指针交换法」
     *
     *1，首先选定基准元素 pivot，并且设置两个指针，指向数列的最左和最右的元素。
     *
     *2，从 right 指针开始，把指针所指向的元素和基准元素做比较，如果 `大于` pivot，则 right 指针向左移动，
     * 如果小于 pivot，则 right 指针停止移动。切换到 left 指针。
     *
     *3，把 left 指针所指向的元素和基准元素做比较，如果 `小于等于` pivot，则 left 指针向右移动，
     * 如果大于 pivot，则 left 指针停止移动。
     *
     * 4，第一次循环，当两个指针分别停下来，让两个指针指向的数据进行交换，然后进行第二轮循环，依此类推， 直至两个指针重合为止。
     *
     * 5，当两个指针重合时，注意这个时候我们让 pivot = 俩指针指向的那个数，此时 pivot 左边的数就都比 pivot 小，右边的数就比 pivot 大。
     *
     * 6，上面的动作递归一下，就 ok 啦。
     *
     * Ref: https://juejin.cn/post/6963592805885149215
     * **/
    private fun quickSort(array: IntArray, leftIndex: Int, rightIndex: Int) {
        if (leftIndex >= rightIndex) {
            return
        }

        // 得到基准元素位置
        val pivotIndex = partition(array, leftIndex, rightIndex)

        // 根据基准元素，分成两部分递归排序
        quickSort(array, leftIndex, pivotIndex - 1)
        quickSort(array, pivotIndex + 1, rightIndex)
    }

    private fun partition(array: IntArray, leftIndex: Int, rightIndex: Int): Int {
        // 取第一个位置的元素作为基准元素
        val pivot = array[leftIndex]

        var left = leftIndex
        var right = rightIndex

        while (left != right) {
            while (left < right && array[right] > pivot) {
                right--
            }

            while (left < right && array[left] <= pivot) {
                left++
            }

            if (left < right) {
                array[left] = array[right].also { array[right] = array[left] }
            }
        }

        // pivot 和指针重合点交换
        array[left] = array[leftIndex].also { array[leftIndex] = array[left] }
        return left
    }
}