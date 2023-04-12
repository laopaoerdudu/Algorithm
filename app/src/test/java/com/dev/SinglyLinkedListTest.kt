package com.dev

import org.junit.Test

class SinglyLinkedListTest {
    private val linked = SinglyLinkedList()

    @Test
    fun test() {
        linked.insertNodeToTail(1)
        linked.insertNodeToTail(10)
        linked.insertNodeToTail(100)
        linked.insertNodeToTail(1000)

        linked.printAll()
    }

    @Test
    fun testDeleteNodeByValue() {
        // GIVEN
        linked.insertNodeToTail(1)
        linked.insertNodeToTail(10)
        linked.insertNodeToTail(100)
        linked.insertNodeToTail(1000)

        // WHEN
        linked.deleteNodeByValue(1000)

        // THEN
        linked.printAll()
    }

    @Test
    fun testDeleteSpecNode() {
        // GIVEN
        linked.insertNodeToTail(1)
        linked.insertNodeToTail(10)
        linked.insertNodeToTail(100)
        linked.insertNodeToTail(1000)

        // WHEN
        linked.deleteSpecNode(SinglyLinkedList.Node(1, null))

        // THEN
        linked.printAll()
    }

    @Test
    fun testFindNodeByValue() {
        // GIVEN
        linked.insertNodeToTail(1)
        linked.insertNodeToTail(10)
        linked.insertNodeToTail(100)

        // WHEN
        val node = linked.findNodeByValue(10)

        // THEN
        println(node)
    }

    @Test
    fun testFindNodeByIndex() {
        // GIVEN
        linked.insertNodeToTail(1)
        linked.insertNodeToTail(10)
        linked.insertNodeToTail(100)

        // WHEN
        val node = linked.findNodeByIndex(1)

        // THEN
        println(node)
    }

    @Test
    fun testInsertValueBeforeSpecNode() {
        // GIVEN
        linked.insertNodeToTail(1)
        linked.insertNodeToTail(100)

        // WHEN
        linked.insertValueBeforeSpecNode(100, 10)

        // THEN
        linked.printAll() // 1, 10, 100
    }

    @Test
    fun testInsertValueAfterSpecNode() {
        // GIVEN
        linked.insertNodeToTail(1)
        linked.insertNodeToTail(100)

        // WHEN
        linked.insertValueAfterSpecNode(100, 1000)

        // THEN
        linked.printAll() // 1, 100, 1000
    }
}