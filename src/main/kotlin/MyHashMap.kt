import java.util.LinkedList
import kotlin.math.pow

class MyHashMap() {

    private class Node(var key: Int?, var value: Int, var next: Node?)

    private val map = mutableListOf<Node>()
    private val load = 10
    private val size = 2.0.pow(load).toInt()

    init {
        for (i in 0..<size) {
            map.add(Node(null, -1, null))
        }
    }

    fun put(key: Int, value: Int) {
        val ind = key and (size - 1)
        if (map[ind].key == null) {
            map[ind] = Node(key, value, null)
            return
        } else {
            var curr: Node? = map[ind]
            while (curr?.next != null) {
                if (curr.key == key) {
                    curr.value = value
                    return
                }
                curr = curr.next
            }
            if (curr?.key == key) {
                curr.value = value
                return
            }
            curr?.next = Node(key, value, null)
        }
    }

    fun get(key: Int): Int {
        val ind = key and (size - 1)
        var curr: Node? = map[ind]
        while (curr != null) {
            if (curr.key == key) return curr.value
            curr = curr.next
        }
        return -1
    }

    fun remove(key: Int) {
        val ind = key and (size - 1)
        var curr: Node? = map[ind]
        if (curr?.key == key) {
            if (curr.next == null) curr.key = null
            else map[ind] = curr.next!!
            return
        }
        while (curr?.next != null) {
            if (curr.next?.key == key) {
                curr.next = curr.next?.next
            }
            curr = curr.next
        }
    }
}