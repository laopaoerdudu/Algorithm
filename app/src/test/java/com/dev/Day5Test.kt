package com.dev

import org.junit.Test

/**
 * 两个有序的链表合并
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
class Day5Test {

    @Test
    fun test() {
        // GIVEN

        // WHEN

        // THEN
    }

    private fun mergeTwoLists(nodeA: ListNode?, nodeB: ListNode?): ListNode? {
        return when {
            nodeA == null -> nodeB

            nodeB == null -> nodeA

            nodeA.value < nodeB.value -> {
                nodeA.next = mergeTwoLists(nodeA.next, nodeB)
                nodeA
            }

            else -> {
                nodeB.next = mergeTwoLists(nodeA, nodeB.next)
                nodeB
            }
        }
    }

    private fun mergeTwoLists2(nodeA: ListNode?, nodeB: ListNode?): ListNode? {
        var mockA = nodeA
        var mockB = nodeB
        val placeholderNode = ListNode(-1)
        var prev = placeholderNode
        while (mockA != null && mockB != null) {
            if (mockA.value <= mockB.value) {
                prev.next = mockA
                mockA = mockA.next
            } else {
                prev.next = mockB
                mockB = mockB.next
            }
            prev = prev.next!!
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = mockA ?: mockB
        return placeholderNode.next
    }
}