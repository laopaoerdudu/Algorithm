package com.dev.link_lru;

public class LRUBaseLinkedList<T> {
    private final static Integer DEFAULT_CAPACITY = 10;
    private SNode<T> headNode;
    private Integer length;
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteNextNode(preNode);
            insertSpecifiedNodeToLinkHead(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteTailNode();
            }
            insertSpecifiedNodeToLinkHead(data);
        }
    }

    private void deleteTailNode() {
        SNode temp = headNode;
        if (temp.getNext() == null) {
            return;
        }

        // 找到倒数第二个结点
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }

        SNode tail = temp.getNext();
        temp.setNext(null);
        tail = null;
        length--;
    }


    /** 删除指定节点的下一个节点 */
    private void deleteNextNode(SNode curNode) {
        SNode temp = curNode.getNext();
        curNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /** 链表头部插入指定的节点 */
    private void insertSpecifiedNodeToLinkHead(T data) {
        SNode newNode = new SNode(data, headNode);
        headNode = newNode;
//        SNode next = headNode.getNext();
//        headNode.setNext(new SNode(data, next));
        length++;
    }

    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }


    public class SNode<T> {

        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
}
