package com.dev

class CircularQueue(
    private val capacity: Int = 0
) {
    private val array: Array<String?> = Array(capacity) { null }
    private var head = 0
    private var tail = 0

    fun enqueue(data: String?): Boolean {
        if ((tail + 1) % capacity == head) {
            return false
        }
        array[tail] = data
        tail = (tail + 1) % capacity
        return true
    }

    fun dequeue(): String? {
        if (head == tail) {
            return null
        }
        val result = array[head]
        head = (head + 1) % capacity
        return result
    }
}