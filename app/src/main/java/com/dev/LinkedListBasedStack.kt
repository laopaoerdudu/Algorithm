package com.dev

class LinkedListBasedStack(
    private var _size: Int = 0,
    private var head: NodeStr? = null
) {
    val size: Int
        get() = _size

    fun clear() {
        this.head = null
        _size = 0
    }

    fun push(data: String?) {
        head = NodeStr(data, this.head)
        this._size++
    }

    fun pop(): String? {
        this.head ?: return null
        val result = head?.data
        head = head?.next
        if (_size > 0) {
            _size--
        }
        return result
    }

    fun printAll() {
        println("Print stack:")
        var cur: NodeStr? = this.head
        while (cur != null) {
            print("${cur.data}\t")
            cur = cur.next
        }
    }
}