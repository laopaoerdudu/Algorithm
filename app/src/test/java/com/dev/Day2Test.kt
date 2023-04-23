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
        if (head == null) {
            return null
        }
        var cur: ListNode? = head
        var prev: ListNode? = null
        while (cur != null) {
           val temp = cur.next
            cur.next = prev
            prev = cur // prev 移动到 cur
            cur = temp
        }
        return prev
    }
}