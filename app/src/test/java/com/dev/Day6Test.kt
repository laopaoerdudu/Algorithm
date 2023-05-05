package com.dev

import org.junit.Test

/** 删除链表倒数第 n 个结点 */
class Day6Test {

    @Test
    fun test() {
        // 1，找到第 n 个节点
        // 2， 删除这个节点
    }

    private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null
        val dummy: ListNode  = head
        val length = getLength(head)

        var cur = dummy

        (0 until (length - n)).forEach { _ ->
            cur = cur.next!!
        }
        cur.next = cur.next?.next
        return dummy.next
    }

    private fun getLength(head: ListNode?): Int {
        var num = 0
        var temp = head
        while (temp != null) {
            ++num
            temp = head?.next
        }
        return num
    }
}