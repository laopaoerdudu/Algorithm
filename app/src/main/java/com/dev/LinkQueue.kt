package com.dev

class LinkQueue {
    private var head: Node? = null
    private var tail: Node? = null

    fun enqueue(data: String) {
        val newNode = Node(data, null)
        tail?.let { _tail ->
            _tail.next = newNode
            // Update tail point
            tail = newNode
        } ?: run {
            tail = newNode
            head = newNode
        }
    }

    fun dequeue(): String? {
        head ?: return null
        val value = head?.date
        head = head?.next
        head ?: run { tail = null }
        return value
    }

    fun printAll() {
        while (head != null) {
            print("${head?.date} ")
            head = head?.next
        }
    }
}