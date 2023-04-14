package com.dev.array

class DynamicArray(private var capacity: Int = 10) {
    private var usedSize = 0
    private var data: Array<Int> = Array(this.capacity) { 0 }

    fun add(value: Int) {
        if (this.usedSize == this.capacity - 1) {
            this.doubleCapacity()
        }
        this.data[this.usedSize] = value
        ++this.usedSize
    }

    fun remove(value: Int) {
        if (this.usedSize < 1) {
            return
        }

        var target = -1

        (0 until this.usedSize).forEach { index ->
            if (this.data[index] == value) {
                target = index
                return@forEach
            }
        }

        if (target == -1) {
            return
        }

        (target + 1 until this.capacity).forEach { index ->
            this.data[index - 1] = this.data[index]
        }
        --usedSize
    }

    fun set(index: Int, value: Int) {
        if (this.checkIndex(index)) {
            this.data[index] = value
            return
        }

        throw IllegalArgumentException("index must be in rang of 0..${this.usedSize}")
    }

    fun get(index: Int): Int? {
        if (this.checkIndex(index)) {
            return this.data[index]
        }

        throw IllegalArgumentException("index must be in rang of 0..${this.usedSize}")
    }

    fun getArray(): String {
        val sb = StringBuilder()
        data.forEachIndexed { index, value ->
            sb.append("$value")
            if (index != data.lastIndex) {
                sb.append(", ")
            }
        }
        return sb.toString()
    }

    fun printArray() {
        val sb = StringBuilder()
        data.forEachIndexed { index, value ->
            sb.append("$value")
            if (index != data.lastIndex) {
                sb.append(", ")
            }
        }
        println(sb.toString())
    }

    private fun checkIndex(index: Int): Boolean {
        return index >= 0 && index < this.usedSize
    }

    private fun doubleCapacity() {
        if (this.capacity < MAX_CAPACITY) {
            this.capacity = (this.capacity * 2).coerceAtMost(MAX_CAPACITY)
            val newArray = Array(this.capacity) { 0 }
            for (i in 0 until this.usedSize) {
                newArray[i] = this.data[i]
            }
            this.data = newArray
        }
    }

    companion object {
        const val MAX_CAPACITY = Int.MAX_VALUE
    }
}