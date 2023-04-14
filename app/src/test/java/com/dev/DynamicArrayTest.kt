package com.dev

import com.dev.array.DynamicArray
import org.junit.Test
import junit.framework.TestCase.assertEquals

class DynamicArrayTest {

    @Test
    fun testAdd() {
        // GIVEN
        val array = DynamicArray(3)

        // WHEN
        array.add(1)
        array.add(3)
        array.add(5)

        // THEN
        assertEquals("1, 3, 5, 0, 0, 0", array.getArray())
    }

    @Test
    fun testRemove() {
        // GIVEN
        val array = DynamicArray(10)
        array.add(1)
        array.add(3)
        array.add(5)

        // WHEN
        array.remove(5)

        // THEN
        array.printArray()

    }
}