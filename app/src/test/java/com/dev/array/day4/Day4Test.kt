package com.dev.array.day4

import org.junit.Test

class Day4Test {

    @Test
    fun test() {
        assert(2 == fib(4))
        assert(21 == fib(9))
    }

    /**
     * 递推公式如下：f(n) = f(n-1) + f(n-2);
     * 终止条件：n <= 1
     * 斐波那契数列 0，1，1，2，3，5，8，13，21，34，55，89，144, ...
     * */
    private fun fib(n: Int): Int {
        if (n <= 1) {
            return -1
        }

        var a = 0
        var b = 0
        var c = 1
        for (i in 2 until n) {
            a = b
            b = c
            c = a + b
        }
        return c
    }
}