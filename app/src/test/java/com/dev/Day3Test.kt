package com.dev

import org.junit.Test

/**
 * 链表中环的检测？
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * https://cloud.tencent.com/developer/article/1799333
 */
class Day3Test {

    @Test
    fun test() {

    }

    /** 如果有环，快慢指针就会一直在这个环里面循环，总归会有相遇的一次 */
    private fun hasCycle(head: ListNode?): Boolean {
        var fast: ListNode? = head
        var slow: ListNode? = head
        while (fast?.next != null) {
            fast = fast?.next?.next
            slow = slow?.next
            if (slow == fast) {
                return true
            }
        }
        return false
    }

    private fun hasCycleSolution(head: ListNode?): Boolean {
        head ?: return false
        var point: ListNode = head
        val nodeSet = HashSet<ListNode>()
        while (point != null) {
            if (!nodeSet.add(point)) {
                return true
            }
            point = point.next!!
        }
        return false
    }
}