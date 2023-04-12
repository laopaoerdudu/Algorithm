package com.dev

class SinglyLinkedList {
    private var head: Node? = null

    fun findNodeByValue(value: Int): Node? {
        var temp = head
        while (temp != null && temp.data != value) {
            temp = temp.next
        }
        return temp
    }

    fun findNodeByIndex(index: Int): Node? {
        var temp = head
        var pos = 0
        while (temp != null && pos != index) {
            temp = temp.next
            ++pos
        }
        return temp
    }

    fun insertNodeToTail(value: Int) {
        val newNode = Node(value, null)
        if (head == null) {
            head = newNode
        } else {
            var temp = head
            while (temp?.next != null) {
                temp = temp.next
            }
            temp?.next = newNode
            newNode.next = null
        }
    }

    fun insertNodeAfterSpecNode(specNode: Node?, value: Int) {
        val newNode = Node(value, null)
        insertNodeAfterSpecNode(specNode, newNode)
    }

    private fun insertNodeAfterSpecNode(specNode: Node?, newNode: Node) {
        if (specNode == null) return

        newNode.next = specNode.next
        specNode.next = newNode
    }

    fun insertValueBeforeSpecNode(nodeValue: Int, value: Int) {
        // TODO: update it in next phase
    }

    fun insertValueAfterSpecNode(nodeValue: Int, value: Int) {
        // TODO: update it in next phase
    }

    fun insertNodeBeforeSpecNode(specNode: Node?, value: Int) {
        val newNode = Node(value, null)
        insertNodeBeforeSpecNode(specNode, newNode)
    }

    private fun insertNodeBeforeSpecNode(specNode: Node?, newNode: Node) {
        if (specNode == null) return
        if (head === specNode) {
            insertNodeToHead(newNode)
            return
        }

        var temp = head
        while (temp != null && temp.next !== specNode) {
            temp = temp.next
        }
        if (temp == null) {
            return
        }

        newNode.next = specNode
        temp.next = newNode
    }

    fun insertNodeToHead(value: Int) {
        val newNode = Node(value, null)
        insertNodeToHead(newNode)
    }

    private fun insertNodeToHead(newNode: Node) {
        if (head == null) {
            head = newNode
        } else {
            newNode.next = head
            head = newNode
        }
    }

    fun deleteSpecNode(specNode: Node?) {
        if (specNode == null || head == null) return

        if (specNode === head) {
            head = head?.next
            return
        }

        var temp = head
        while (temp != null && temp.next !== specNode) {
            temp = temp.next
        }

        if (temp == null) {
            return
        }

        temp.next = temp.next?.next
    }

    fun deleteNodeByValue(value: Int) {
        if (head == null) return

        var targetNode = head
        var lastNode: Node? = null
        while (targetNode != null && targetNode.data != value) {
            lastNode = targetNode
            targetNode = targetNode.next
        }

        if (targetNode == null) return

        if (lastNode == null) {
            head = head?.next
        } else {
            lastNode.next = lastNode.next?.next
        }
    }

    fun printAll() {
        var temp = head
        while (temp != null) {
            print("${temp.data} ")
            temp = temp.next
        }
        println()
    }

    class Node(var data: Int, var next: Node?) {

        override fun toString(): String {
            return "data: $data, next: ${next?.data}"
        }
    }
}