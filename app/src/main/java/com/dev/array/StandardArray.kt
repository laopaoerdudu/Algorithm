package com.dev.array

class StandardArray constructor(private val capacity: Int) {
    private val data: IntArray = IntArray(capacity)
    private var count: Int = 0

    fun find(index: Int): Int {
        if (index !in 0 until count) return -1
        return data[index]
    }

    fun insert(index: Int, value: Int): Boolean {
        if (count == capacity) {
            return false
        }

        if (index !in 0 until capacity) {
            return false
        }

        (count downTo index + 1).forEach {
            data[it] = data[it - 1]
        }
        data[index] = value
        ++count
        return true
    }

    fun delete(index: Int): Boolean {
        if (index !in 0 until capacity) return false
        (index + 1 until capacity).forEach {
            data[it - 1] = data[it]
        }
        --count
        return true
    }

    fun getArray(): String {
        val sb = StringBuilder()
        data.forEachIndexed { index, value ->
            sb.append("$value")
            if (index != data.lastIndex) {
                sb.append(", ")
            }
        }
        return sb.toString()
    }

    fun printArray() {
        val sb = StringBuilder()
        data.forEachIndexed { index, value ->
            sb.append("$value")
            if (index != data.lastIndex) {
                sb.append(", ")
            }
        }
        println(sb.toString())
    }
}