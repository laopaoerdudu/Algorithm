package com.dev.array

class StandardArray constructor(private val capacity: Int) {
    private val array: IntArray = IntArray(capacity)
    private var num: Int = 0

    fun find(index: Int): Int {
        if (index !in 0 until num) return -1
        return array[index]
    }

    fun insert(index: Int, value: Int): Boolean {
        if (num == capacity) {
            return false
        }

        if (index !in 0 until capacity) {
            return false
        }

        (num downTo index + 1).forEach { i ->
            array[i] = array[i - 1]
        }
        array[index] = value
        num++
        return true
    }

    fun delete(index: Int): Boolean {
        if (index !in 0 until capacity) return false
        (index + 1 until num).forEach { i ->
            array[i - 1] = array[i]
        }
        num--
        return true
    }

    fun getArray(): String {
        val sb = StringBuilder()
        array.forEachIndexed { index, value ->
            sb.append("$value")
            if (index != array.lastIndex) {
                sb.append(", ")
            }
        }
        return sb.toString()
    }

    fun printArray() {
        val sb = StringBuilder()
        array.forEachIndexed { index, value ->
            sb.append("$value")
            if (index != array.lastIndex) {
                sb.append(", ")
            }
        }
        println(sb.toString())
    }
}