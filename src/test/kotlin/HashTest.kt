import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class HashTest {

    val hash = Hash()
    @Test
    fun containsDuplicate() {
        assertTrue(hash.containsDuplicate(intArrayOf(1,2,3,1)))
        assertFalse(hash.containsDuplicate(intArrayOf(1,2,3,4)))
        assertTrue(hash.containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
    }
}