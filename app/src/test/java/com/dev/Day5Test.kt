package com.dev

import org.junit.Test
import java.util.Deque
import java.util.LinkedList

class Day5Test {

    @Test
    fun test() {
        // WHEN
        val result = longestValidParentheses("())((())()")

        // THEN
        assert(6 == result)
    }

    private fun longestValidParentheses(data: String): Int {
        var max = 0
        val stack: Deque<Int> = LinkedList()
        stack.push(-1)

        val size = data.length
        (0 until size).forEach { i ->
            if (data[i] == '(') {
                stack.push(i)
            } else {
                stack.pop() // Removes and returns the first element of this deque.
                if (stack.isEmpty()) {
                    stack.push(i)
                } else {
                    // The head of the queue represented by this deque, or null if this deque is empty
                    max = max.coerceAtLeast(i - stack.peek())
                }
            }
        }
        return max
    }
}