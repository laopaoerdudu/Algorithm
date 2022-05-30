package com.dev.array.day2

import org.junit.Test

class Day2Test {

    @Test
    fun test1() {
        // 最小堆法（每个父节点都小于子节点）
        val array = arrayOf(7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8)

        assert(12 == getResultViaMinHeap(array, 5))
    }

    private fun getResultViaMinHeap(array: Array<Int>, k: Int): Int {
        // 用前 k 个元素构建最小堆
        buildHeap(array, k)

        // 遍历数组，和堆顶比较
        for (i in k..array.lastIndex) {
            if (array[i] > array[0]) {
                array[0] = array[i]
                downAdjust(array, 0, k)
            }
        }

        // 返回堆定元素
        return array[0]
    }

    private fun buildHeap(array: Array<Int>, heapSize: Int) {
        // 从最后一个非叶子结点开始，依次下沉调整
        val size: Int = (heapSize - 2) / 2
        for (i in size downTo 0) {
            downAdjust(array, i, heapSize)
        }
    }

    /** 堆的内部调整，满足最小堆，堆永远维持 length 大小 */
    private fun downAdjust(array: Array<Int>, index: Int, length: Int) {
        // 记录父节点的下标
        var indexShadow = index

        // 记录左子节点的下标
        var childIndex = (2 * indexShadow) + 1

        // temp 记录父结点的值
        val temp = array[indexShadow]

        // length 是堆的有效长度
        while (childIndex < length) {

            // 如果有右节点，且右节点小于左节点的值，则定位到右节点
            if (((childIndex + 1) < length) && (array[childIndex + 1] < array[childIndex])) {
                childIndex++
            }

            // 如果父结点小于任何一个孩子的值，直接跳出
            if (temp <= array[childIndex]) {
                break
            }

            array[indexShadow] = array[childIndex]
            indexShadow = childIndex
            childIndex = (2 * indexShadow) + 1
        }

        array[indexShadow] = temp
    }
}