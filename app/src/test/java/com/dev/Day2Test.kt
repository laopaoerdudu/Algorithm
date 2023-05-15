package com.dev

import org.junit.Assert.assertEquals
import org.junit.Test

class Day2Test {

    @Test
    fun testPush() {
        // GIVEN
        val array = ArrayStack(3)

        // WHEN
        array.push("Roman")
        array.push("Drew")
        array.push("Seth")

        // THEN
        assertEquals("Seth", array.pop())
    }
}