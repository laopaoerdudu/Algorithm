package com.dev.array

class DynamicArray(private var capacity: Int = 10) {
    private var num = 0
    private var array: Array<String?> = Array(this.capacity) { null }

    fun add(index: Int, value: String): Boolean {
        if (isEligible(index).not()) {
            return false
        }
        // Enlarge space
        if (num == capacity - 1) {
            doubleCapacity()
        }
        (num downTo index + 1).forEach { i ->
            array[i] = array[i - 1]
        }
        array[index] = value
        num++
        return true
    }

    fun remove(value: String?) {
        if (this.num < 1) {
            return
        }

        var target = -1

        (0 until this.num).forEach { index ->
            if (this.array[index] == value) {
                target = index
                return@forEach
            }
        }

        if (target == -1) {
            return
        }

        (target + 1 until this.capacity).forEach { index ->
            this.array[index - 1] = this.array[index]
        }
        --num
    }

    fun size(): Int {
        return num
    }

    fun isEmpty(): Boolean {
        return num == 0
    }

    /** Update value by the given index */
    fun set(index: Int, value: String): Boolean {
        if (isEligible(index).not()) {
            return false
        }
        array[index] = value
        return true
    }

    fun get(index: Int): String? {
        if (isEligible(index).not()) {
            return null
        }
        return array[index]
    }

    fun contains(value: String?): Boolean {
        array.forEach {
            if (it == value) {
                return true
            }
        }
        return false
    }

    fun find(value: String?): Int {
        (0..array.lastIndex).forEach { i ->
            if (array[i] == value) {
                return i
            }
        }
        return -1
    }

    private fun doubleCapacity() {
        if (this.capacity < MAX_CAPACITY) {
            this.capacity = (this.capacity * 2).coerceAtMost(MAX_CAPACITY)
            val newArray = Array<String?>(this.capacity) { null }
            for (i in 0 until this.num) {
                newArray[i] = this.array[i]
            }
            this.array = newArray
        }
    }

    private fun isEligible(index: Int): Boolean {
        if (index !in 0 until capacity) {
            return false
        }
        return true
    }

    companion object {
        const val MAX_CAPACITY = Int.MAX_VALUE
    }
}