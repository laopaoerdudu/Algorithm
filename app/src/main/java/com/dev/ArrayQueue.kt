package com.dev

class ArrayQueue(
    private val capacity: Int = 0
) {
    private val array: Array<String?> = Array(capacity) { null }
    private var head: Int = 0
    private var tail = 0

    fun enqueue(data: String?): Boolean {
        data ?: return false
        if (tail == capacity) {
            return false
        }
        array[tail++] = data
        return true
    }

    fun dequeue(): String? {
        if (head == tail) {
            return null
        }
        val result = array[head]
        ++head
        return result
    }
}