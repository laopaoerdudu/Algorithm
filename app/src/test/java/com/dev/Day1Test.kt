package com.dev

import org.junit.Test
import java.util.Deque
import java.util.LinkedList

/**
 * pop(): Removes and returns the first element of this deque.
 * peek(): the head of the queue represented by this deque.
 */
class Day1Test {
    private val pairs = hashMapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']'
    )

    @Test
    fun test() {
        // GIVEN
        val data = "()[]{}"

        // THEN
        assert(isValid(data))
    }

    private fun isValid(data: String): Boolean {
        val length = data.length

        if (length % 2 == 1) {
            return false
        }

        val stack: Deque<Char> = LinkedList()

        (0 until length).forEach { i ->
            val value: Char = data[i]

            when {
                value == '(' -> stack.push(')')

                value == '{' -> stack.push('}')

                value == '[' -> stack.push(']')

                stack.isEmpty() || stack.peek() != value -> return false

                else -> stack.pop()
            }
        }
        return stack.isEmpty()
    }
}