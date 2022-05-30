package com.dev

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        //val array = arrayOf(38, 18, 23, 4, 5, 47, 39, 3, 8, 15)
        //assert(!array.contains(100))

        val sb = ""
        assert(sb.isNullOrBlank())
    }

    @Test
    fun `Test LinkedHashMap`() {
        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        //  LinkedHashMap 本身就是一个支持 LRU 缓存淘汰策略的缓存系统
        // LinkedHashMap 是通过双向链表和散列表这两种数据结构组合实现的。
        // LinkedHashMap 中的“Linked”实际上是指的是双向链表，并非指用链表法解决散列冲突。
        val map = LinkedHashMap<Int, Int>(10, 0.75f, true).apply {
            put(3, 11)
            put(1, 12)
            put(5, 23)
            put(2, 22)
            put(3, 26)
            get(5)
        }

        for ((key, value) in map) {
            print("$key ") // 1 2 3 5
        }
    }
}