package com.dev

import com.dev.array.StandardArray
import junit.framework.TestCase.assertEquals
import org.junit.Test

class StandardArrayTest {

    @Test
    fun test() {
        val array = IntArray(10)
        array[1] = 10
        array[3] = 30
        array[5] = 50
        array[7] = 70

        array[3] = 0
        val sb = StringBuilder()
        array.forEachIndexed { index, value ->
            sb.append("($index, $value), ")
        }
        println(sb.toString())
    }

    @Test
    fun test1() {
        val array = Array(10) { 0 }
        array[1] = 10
        array[3] = 30
        array[5] = 50
        array[7] = 70

        val sb = StringBuilder()
        array.forEachIndexed { index, value ->
            sb.append("($index, $value), ")
        }
        println(sb.toString())
    }

    @Test
    fun testInsert() {
        // GIVEN
        val array = StandardArray(10)

        // WHEN
        array.insert(1, 10)
        array.insert(3, 30)
        array.insert(5, 50)
        array.insert(7, 70)

        // THEN
        assertEquals("0, 10, 0, 30, 0, 50, 0, 70, 0, 0", array.getArray())
    }

    @Test
    fun testDelete() {
        // GIVEN
        val array = StandardArray(10).apply {
            insert(1, 10)
            insert(3, 30)
            insert(5, 50)
            insert(7, 70)
        }

        // WHEN
        array.delete(7)

        // THEN
        array.printArray()
    }

    @Test
    fun testFind() {
        // GIVEN
        val array = StandardArray(10).apply {
            insert(1, 10)
            insert(3, 30)
            insert(5, 50)
            insert(7, 70)
        }

        // THEN
        assertEquals(30, array.find(3))
    }
}