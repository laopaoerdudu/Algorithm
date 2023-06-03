package com.dev

import org.junit.Test

/**
 * 单链表反转
 * https://juejin.cn/post/6844904058562543623
 */
class Day2Test {

    @Test
    fun test() {

    }

    private fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur: ListNode? = head
        while (cur != null) {
            var nextNode = cur.next
            // 翻转
            cur.next = prev
            // 移动指针
            prev = cur
            cur = nextNode
        }
        return prev
    }
}