package com.dev.array.day6

import org.junit.Test
import java.util.*

class Day6Test {

    @Test
    fun test() {
        // GIVEN
        val array = intArrayOf(1, 2, 3, 1)

        // THEN
        assert(containsDuplicate(array))
    }

    private fun containsDuplicate(array: IntArray): Boolean {
        Arrays.sort(array)
        for(i in 0..array.lastIndex) {
            if (array[i] == array[i + 1]) {
                return true
            }
        }
        return false
    }
}