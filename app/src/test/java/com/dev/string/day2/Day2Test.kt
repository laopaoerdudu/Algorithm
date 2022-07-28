package com.dev.string.day2

import org.junit.Test

class Day2Test {

    @Test
    fun test() {
        // GIVEN
        val string = "aabb"

        // WHEN
        val index = getIndex(string.toCharArray())

        // THEN
        assert(-1 == index)
    }

    private fun getIndex(array: CharArray): Int {
        val map = mutableMapOf<Char, Int>()
        array.forEach { char ->
            map[char] = map.getOrDefault(char, 0) + 1
        }
        for (i in 0..array.lastIndex) {
            if (map[array[i]] == 1) {
                return i
            }
        }
        return -1
    }
}