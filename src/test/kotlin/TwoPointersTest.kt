import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoPointersTest {
    private val test = TwoPointers()

    @Test
    fun testMerge() {
        var t = intArrayOf(1, 2, 3, 0, 0, 0)
        test.merge(t, 3, intArrayOf(2, 5, 6), 3)
        assertTrue(intArrayOf(1, 2, 2, 3, 5, 6).myEquals(t))

        t = intArrayOf(1, 2, 3, 0, 0, 0, 0)
        test.merge(t, 3, intArrayOf(2, 5, 6, 8), 4)
        assertTrue(intArrayOf(1, 2, 2, 3, 5, 6, 8).myEquals(t))

        t = intArrayOf(1)
        test.merge(t, 1, intArrayOf(), 0)
        assertTrue(intArrayOf(1).myEquals(t))

        t = intArrayOf(0)
        test.merge(t, 0, intArrayOf(1), 1)
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

    @Test
    fun testReversePrefix() {
        assertEquals("dcbaefd", test.reversePrefix("abcdefd", 'd'))
    }

    @Test
    fun testRemoveDupl() {
        var nums = intArrayOf(1,1,2)
        var expectedNums = intArrayOf(1,2)
        var k = test.removeDuplicates(nums)
        assertEquals(expectedNums.size, k)
        for (i in expectedNums.indices) {
            assertEquals(nums[i], expectedNums[i])
        }

        nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        expectedNums = intArrayOf(0,1,2,3,4)
        k = test.removeDuplicates(nums)
        assertEquals(expectedNums.size, k)
        for (i in expectedNums.indices) {
            assertEquals(nums[i], expectedNums[i])
        }
    }

    @Test
    fun testMoveZero() {
        var t = intArrayOf(1, 2, 3, 0, 0, 0)
        test.moveZeroes(t)
        assertTrue(intArrayOf(1, 2, 3, 0, 0, 0).myEquals(t))

        t = intArrayOf(1, 2, 3, 0, 4, 0)
        test.moveZeroes(t)
        assertTrue(intArrayOf(1, 2, 3, 4, 0, 0).myEquals(t))

        t = intArrayOf(0, 0, 0, 0, 0, 0)
        test.moveZeroes(t)
        assertTrue(intArrayOf(0, 0, 0, 0, 0, 0).myEquals(t))

        t = intArrayOf(0)
        test.moveZeroes(t)
        assertTrue(intArrayOf(0).myEquals(t))

        t = intArrayOf(0, 1, 0, 2, 0, 0)
        test.moveZeroes(t)
        assertTrue(intArrayOf(1, 2, 0, 0, 0, 0).myEquals(t))

        t = intArrayOf(0,1,0,3,12)
        test.moveZeroes(t)
        assertTrue(intArrayOf(1,3,12, 0, 0).myEquals(t))
    }

    @Test
    fun testRemoveDuplicates80() {
        var nums = intArrayOf(1,1,1,2,2,2)
        var expectedNums = intArrayOf(1,1,2,2,)
        var k = test.removeDuplicates80(nums)
        assertEquals(expectedNums.size, k)
        for (i in expectedNums.indices) {
            assertEquals(nums[i], expectedNums[i])
        }

        nums = intArrayOf(0)
        expectedNums = intArrayOf(0)
        k = test.removeDuplicates80(nums)
        assertEquals(expectedNums.size, k)
        for (i in expectedNums.indices) {
            assertEquals(nums[i], expectedNums[i])
        }

        nums = intArrayOf(0,1,1,1)
        expectedNums = intArrayOf(0,1,1)
        k = test.removeDuplicates80(nums)
        assertEquals(expectedNums.size, k)
        for (i in expectedNums.indices) {
            assertEquals(nums[i], expectedNums[i])
        }

        nums = intArrayOf(0,1,1,1)
        expectedNums = intArrayOf(0,1,1)
        k = test.removeDuplicates80(nums)
        assertEquals(expectedNums.size, k)
        for (i in expectedNums.indices) {
            assertEquals(nums[i], expectedNums[i])
        }

        nums = intArrayOf(0,0,1,1,1,1,2,3,3)
        expectedNums = intArrayOf(0,0,1,1,2,3,3)
        k = test.removeDuplicates80(nums)
        assertEquals(expectedNums.size, k)
        for (i in expectedNums.indices) {
            assertEquals(nums[i], expectedNums[i])
        }
    }
}