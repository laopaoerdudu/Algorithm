package com.dev

import org.junit.Test

/**
 * 斐波那契数列求解办法：
 * 大致有这样的一个数列：1, 1, 2, 3, 5, 8, 13，。。。
 * 其中第一、第二项固定为1，后面每一项都是前面两项之和。
 * 使用数学公式就是 f(n) = f(n-1)+f(n-2)
 */
class Day1Test {

    @Test
    fun test() {
        println(f1(7))
        println(f2(7))
        println(f3(7))
    }

    /**
     * 随着 n 的增大，这个算法时间复杂度会指数级增长
     */
    private fun f1(n: Int): Int {
        return when (n) {
            0 -> 1
            in 1..2 -> n
            else -> {
                f1(n - 1) + f1(n - 2)
            }
        }
    }

    /**
     * 从 1 到 n，依次计算f(n)，然后将计算结果存入一个数组（这里需要申请一个数组存储结算结果），最后返回f(n)的结果，问题就解决了。
     */
    private fun f2(n: Int): Int {
        return when (n) {
            0 -> 1
            in 1..2 -> n
            else -> {
                val array: Array<Int> = Array(n) { 1 }
                // 1, 1, 2, 3, 5, 8, 13，。。。
                array[1] = 1
                array[2] = 2
                (3 until n).forEach { i ->
                    array[i] = array[i - 1] + array[i - 2]
                }
                array[n - 1]
            }
        }
    }

    /**
     * 动态规划算法：
     * 时间复杂度还是 O(n)，而空间复杂度变为了 O(1)。
     */
    private fun f3(n: Int): Int {
        return when (n) {
            0 -> 1
            in 1..2 -> n
            else -> {
                var prePre = 1
                var pre = 2
                (3 until n).forEach { _ ->
                    // 1, 1, 2, 3, 5, 8, 13
                    pre += prePre
                    prePre = pre - prePre
                }
                pre
            }
        }
    }
}