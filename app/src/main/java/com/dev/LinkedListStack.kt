package com.dev

class LinkedListStack(
    private var head: Node? = null
) {

    fun push(value: Int) {
        val newNode = Node(value)
        head?.let {
            newNode.next = head
            head = newNode
        } ?: run {
            this.head = newNode
        }
    }

    fun pop(): Int {
        head?.let {
            val result = it.data
            head = head?.next
            return result
        }
        return -1
    }
}