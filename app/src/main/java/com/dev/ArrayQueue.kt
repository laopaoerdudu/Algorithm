package com.dev

/**
 * 在用数组实现的非循环队列中，队满的判断条件是 head = 0, tail == capacity，
 * 队空的判断条件是 head == tail。
 */
class ArrayQueue(
    private val capacity: Int = 0
) {
    private val array: Array<String?> = Array(capacity) { null }
    private var head = 0
    private var tail = 0

    fun enqueue(data: String?): Boolean {
        if (tail == capacity) {
            // Represent the queue is full
            if (head == 0) return false

            // Data migration
            /** 当队列的 tail 指针移动到数组的最右边后，如果有新的数据入队，我们可以将 head 到 tail 之间的数据，整体搬移到数组中 0 到 tail-head 的位置 */
            (head until tail).forEach { i ->
                array[i - head] = array[i]
            }

            // Update head & tail
            tail -= head
            head = 0
        }

        array[tail] = data
        ++tail
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