import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyLinkedListTest {

    @Test
    fun testHead() {
        val m = MyLinkedList()
        m.addAtHead(5)
        m.addAtHead(4)
        m.addAtHead(3)
        m.addAtHead(2)
        m.addAtHead(1)
        for (i in 0..4) {
            assertEquals(i + 1, m.get(i))
        }
    }

    @Test
    fun testTails() {
        val m = MyLinkedList()
        m.addAtTail(0)
        m.addAtTail(1)
        m.addAtTail(2)
        m.addAtTail(3)
        m.addAtTail(4)
        for (i in 0..4) {
            assertEquals(i, m.get(i))
        }
    }

    @Test
    fun testAddIndex() {
        val m = MyLinkedList()
        m.addAtIndex(0, 0)
        m.addAtIndex(1, 1)
        m.addAtIndex(2, 2)
        m.addAtIndex(3, 4)
        m.addAtIndex(3, 3)
        m.addAtIndex(10, 1)
        m.addAtIndex(-1, 1)
        for (i in 0..4) {
            assertEquals(i, m.get(i))
        }
    }

    @Test
    fun testDelete() {
        val m = MyLinkedList()
        m.deleteAtIndex(-1)
        m.deleteAtIndex(0)
        m.deleteAtIndex(10)

        m.addAtTail(0)
        m.addAtTail(1)
        m.addAtTail(2)
        m.addAtTail(3)
        m.addAtTail(4)

        m.deleteAtIndex(2)

        assertEquals(0, m.get(0))
        assertEquals(1, m.get(1))
        assertEquals(3, m.get(2))
        assertEquals(4, m.get(3))
    }

    @Test
    fun test1() {
        val m = MyLinkedList()
        m.addAtHead(1)
        m.addAtTail(3)
        m.addAtIndex(1, 2)
        assertEquals(2, m.get(1))
        m.deleteAtIndex(1)
        assertEquals(3, m.get(1))
    }
    @Test
    fun test2() {
        val m = MyLinkedList()
        m.addAtHead(2)
        m.deleteAtIndex(1)
        m.addAtHead(2)
        m.addAtHead(7)
        m.addAtHead(3)
        m.addAtHead(2)
        m.addAtHead(5)
        m.addAtTail(5)
        assertEquals(2, m.get(5))
    }

    @Test
    fun test3() {
        val m = MyLinkedList()
        m.addAtHead(1)
        m.addAtTail(3)
        m.addAtIndex(1, 2)
        assertEquals(2, m.get(1))
        m.deleteAtIndex(1)
        assertEquals(3, m.get(1))
        assertEquals(-1, m.get(3))
        m.deleteAtIndex(3)
        m.deleteAtIndex(0)
        assertEquals(3, m.get(0))
        m.deleteAtIndex(0)
        assertEquals(-1, m.get(0))
    }

    @Test
    fun test4() {
        val m = MyLinkedList()
        m.addAtIndex(1, 0)
        assertEquals(-1, m.get(0))
    }
}