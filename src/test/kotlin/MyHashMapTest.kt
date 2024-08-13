import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyHashMapTest {

    @Test
    fun testPut() {
        val m = MyHashMap()
        m.put(1, 1)
        assertEquals(1, m.get(1))
        m.put(1024 + 1, 2)
        assertEquals(2, m.get(1024 + 1))
        m.put(1024 * 2 + 1, 3)
        assertEquals(3, m.get(2 * 1024 + 1))
        m.put(1024 * 2 + 1, 5)
        assertEquals(5, m.get(2 * 1024 + 1))
        m.put(1024 + 1, 4)
        assertEquals(4, m.get(1024 + 1))
    }

    @Test
    fun testGet() {
        val m = MyHashMap()

        assertEquals(-1, m.get(100))

        for (i in 0..2) {
            m.put(i * 1024 + 1, i)
        }
        for (i in 0..<2) {
            assertEquals(i, m.get(i * 1024 + 1))
        }
        assertEquals(2, m.get(2 * 1024 + 1))
    }

    @Test
    fun testRemove() {
        val m = MyHashMap()
        m.put(1, 1)
        m.put(1024 + 1, 2)
        m.put(1024 * 2 + 1, 3)
        m.remove(1)
        assertEquals(-1, m.get(1))
        m.remove(1 + 1024 * 2)
        assertEquals(-1, m.get(1 + 1024 * 2))
    }

    @Test
    fun test1() {
        val m = MyHashMap()
        m.put(1,1)
        m.put(2,2)
        assertEquals(1, m.get(1))
        assertEquals(-1, m.get(3))
        m.put(2,1)
        assertEquals(1, m.get(2))
        m.remove(2)
        assertEquals(-1, m.get(2))
    }
}