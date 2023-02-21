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
        if (this.usedSize >= 0) {
            var target = -1

            for (i in 0 until this.usedSize) {
                if (this.data[i] == value) {
                    target = i
                    break
                }
            }

            if (target >= 0) {
                val size = this.usedSize - 1

                // 把后续元素往前搬
                for (i in target until size) {
                    this.data[i] = this.data[i + 1]
                }

                // 最后一个元素位置置为空
                this.data[size] = 0

                // 更新已使用大小
                this.usedSize = size
            }
        }
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