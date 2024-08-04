import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class HashTest {

    private val hash = Hash()
    @Test
    fun containsDuplicate() {
        assertTrue(hash.containsDuplicate(intArrayOf(1,2,3,1)))
        assertFalse(hash.containsDuplicate(intArrayOf(1,2,3,4)))
        assertTrue(hash.containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
    }

    @Test
    fun testContainsNearbyDuplicates() {
        assertTrue(hash.containsNearbyDuplicate(intArrayOf(1,2,3,1), 3))
        assertTrue(hash.containsNearbyDuplicate(intArrayOf(1,0,1,1), 1))
        assertFalse(hash.containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3), 2))
    }

    @Test
    fun testContainsNearbyAlmostDuplicate() {
        assertTrue(hash.containsNearbyAlmostDuplicate(intArrayOf(1,2,3,1), 3, 0))
        assertFalse(hash.containsNearbyAlmostDuplicate(intArrayOf(1,5,9,1,5,9), 2, 3))
        assertTrue(hash.containsNearbyAlmostDuplicate(intArrayOf(1,0,1,1), 1, 2))
    }
}