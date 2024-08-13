class MyLinkedList() {

    private var head: Node? = null
    var size: Int = 0

    private fun getNode(index: Int): Node? {
        if (index == 0) return head
        var curr = head
        for (i in 1..index) {
            curr = curr?.next
        }
        return curr
    }

    fun get(index: Int): Int {
        if (size <= 0 || index !in 0..<size) {
            return -1
        }
        return getNode(index)?.value!!
    }

    fun addAtHead(value: Int) {
        addAtIndex(0, value)
    }

    fun addAtTail(value: Int) {
        addAtIndex(size, value)
    }

    fun addAtIndex(index: Int, value: Int) {
        if (index !in 0..(size + 1)) {
            return
        }
        if (index == 0) {
            val n = Node(value, head)
            head = n
            size++
            return
        }
        val prev = getNode(index - 1)
        prev?.let {
            val oldNext = prev.next
            prev.next = Node(value, oldNext)
            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index !in 0..<size) {
            return
        }
        if (index == 0) {
            head = head?.next
        }
        val prev = getNode(index - 1)
        prev?.next = prev?.next?.next
        size--
    }
}

data class Node(
    var value: Int,
    var next: Node?
)


