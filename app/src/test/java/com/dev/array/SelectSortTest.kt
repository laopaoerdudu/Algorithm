package com.dev.array

import org.junit.Test

class SelectSortTest {

    @Test
    fun test() {
        // GIVEN
        val array = arrayOf(35, 9, 15, 33, 40, 22, 45, 25, 44, 43, 3)

        // WHEN
        selectSort(array)

        // THEN
        assert("[3, 9, 15, 22, 25, 33, 35, 40, 43, 44, 45]" == array.contentToString())
    }

    private fun selectSort(array: Array<Int>) {
        for(i in 0..array.lastIndex) {
            var min = i
            for (j in (i+1)..array.lastIndex) {
                if(array[j] < array[min]) {
                    min = j
                }
            }

            if(i != min) {
                array[i] = array[min].also { array[min] = array[i] }
            }
        }
    }
}