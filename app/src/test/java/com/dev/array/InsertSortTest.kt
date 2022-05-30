package com.dev.array

import org.junit.Test

class InsertSortTest {

    @Test
    fun test() {
        // GIVEN
        val array = arrayOf(32, 45, 20, 1, 44, 26, 9, 3, 34, 27, 21)

        // WHEN
        insertSort(array)

        // THEN
        assert("[1, 3, 9, 20, 21, 26, 27, 32, 34, 44, 45]" == array.contentToString())
    }

    private fun insertSort(array: Array<Int>) {
        for(i in 1..array.lastIndex) {
            for(j in i downTo 1) {
                if(array[j] < array[j - 1]) {
                    array[j] = array[j -1].also { array[j -1] = array[j] }
                }
            }
        }
    }
}