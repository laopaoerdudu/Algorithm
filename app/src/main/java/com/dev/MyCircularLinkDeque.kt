package com.dev

class MyCircularLinkDeque(
    private val capacity: Int = 0
) {
    private var head: NodeLink? = null
    private var tail: NodeLink? = null
    private var size = 0

    fun insertFront(value: String?): Boolean {
        if (isFull()) {
            return false
        }
        val newNode = NodeLink(value)
        if (size == 0) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head?.prev = newNode
            head = newNode
        }
        ++size
        return true
    }

    fun insertLast(value: String?): Boolean {
        if (isFull()) {
            return false
        }
        val newNode = NodeLink(value)
        if (size == 0) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            newNode.prev = tail
            tail = newNode
        }
        ++size
        return true
    }

    fun deleteFront(): Boolean {
        if (size == 0) {
            return false
        }
        head = head?.next
        head?.let {
            it.prev = null
        }
        --size
        return true
    }

    fun deleteLast(): Boolean {
        if (size == 0) {
            return false
        }
        tail = tail?.prev
        tail?.let {
            it.next = null
        }
        --size
        return true
    }

    fun getFront(): String? {
        if (isEmpty()) {
            return null
        }
        return head?.value
    }

    fun getTail(): String? {
        if (isEmpty()) {
            return null
        }
        return tail?.value
    }

    private fun isEmpty(): Boolean {
        return size == 0
    }

    private fun isFull(): Boolean {
        return size == capacity
    }
}