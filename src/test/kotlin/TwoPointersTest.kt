import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoPointersTest {
    private val test = TwoPointers()

    @Test
    fun testMerge() {
        var t = intArrayOf(1, 2, 3, 0, 0, 0)
        test.merge(t, 3, intArrayOf(2, 5, 6), 3)
        println(t)
        assertTrue(intArrayOf(1, 2, 2, 3, 5, 6).myEquals(t))

        t = intArrayOf(1, 2, 3, 0, 0, 0, 0)
        test.merge(t, 3, intArrayOf(2, 5, 6, 8), 4)
        println(t)
        assertTrue(intArrayOf(1, 2, 2, 3, 5, 6, 8).myEquals(t))

        t = intArrayOf(1)
        test.merge(t, 1, intArrayOf(), 0)
        println(t)
        assertTrue(intArrayOf(1).myEquals(t))

        t = intArrayOf(0)
        test.merge(t, 0, intArrayOf(1), 1)
        println(t.toString())
        assertTrue(intArrayOf(1).myEquals(t))
    }

    @Test
    fun testMergeList() {
        var t = mutableListOf(1, 2, 3)
        assertEquals(mutableListOf(1, 2, 2, 3, 5, 6), test.merge(t, mutableListOf(2, 5, 6)))

        t = mutableListOf(1, 2, 3)
        assertEquals(listOf(1, 2, 2, 3, 5, 6, 8), test.merge(t, mutableListOf(2, 5, 6, 8)))

        t = mutableListOf(1)
        assertEquals(mutableListOf(1), test.merge(t, mutableListOf()))

        t = mutableListOf()
        assertEquals(mutableListOf(1), test.merge(t, mutableListOf(1)))
    }
}