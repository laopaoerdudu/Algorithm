package com.dev

class MyCircularDeque(
    private val capacity: Int = 0
) {
    private val array: Array<String?> = Array(capacity) { null }
    private var head = 0
    private var tail = 0

    fun insertFront(value: String?): Boolean {
        if (isFull()) {
            return false
        }
        head = (head - 1 + capacity) % capacity
        array[head] = value
        return true
    }

    fun insertLast(data: String?): Boolean {
        if (isFull()) {
            return false
        }
        array[tail] = data
        tail = (tail + 1) % capacity
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) {
            return false
        }
        head = (head + 1) % capacity
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) {
            return false
        }
        tail = (tail - 1 + capacity) % capacity
        return true
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    private fun isEmpty(): Boolean {
        return tail == head
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    private fun isFull(): Boolean {
        return (tail + 1) % capacity == head
    }

    fun getFrontData(): String? {
        if (isEmpty()) {
            return null
        }
        return array[head]
    }

    /**
     * Get the last item from the queue
     */
    fun getTailData(): String? {
        if (isEmpty()) {
            return null
        }
        return array[(tail - 1 + capacity) % capacity]
    }
}