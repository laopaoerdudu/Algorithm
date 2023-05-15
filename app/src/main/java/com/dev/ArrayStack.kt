package com.dev

class ArrayStack(private val capacity: Int) {
    private var array: Array<String?> = Array(capacity) { null }
    private var num = 0

    fun push(item: String): Boolean {
        if (num == capacity) {
            return false
        }
        array[num++] = item
        return true
    }

    fun pop(): String? {
        if (num == 0) {
            return null
        }
        val result = array[num - 1]
        --num
        return result
    }
}