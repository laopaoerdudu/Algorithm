package com.dev

import org.junit.Test

/**
 * 双指针的思路，还是可以看成两个人一起走路，两个人一起出发，一个人的速度是另一个人的两倍。
 * 这样快的人到达末尾，慢的人刚好在中间的位置。
 */
class Day7Test {

    @Test
    fun test() {

    }

    private fun getMiddleNode(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }
}