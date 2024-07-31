import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OtherTest {
    private val test = Other()

    @Test
    fun testPalindromeSimple() {
        assertTrue(test.isPalindrome(12521))
        assertFalse(test.isPalindrome(125211))
        assertTrue(test.isPalindrome(1))
        assertTrue(test.isPalindrome(-1))
    }

    @Test
    fun testCountPairs() {
        assertEquals(3, test.countPairs(listOf(-1,1,2,3,1), 2))
        assertEquals(10, test.countPairs(listOf(-6,2,5,-2,-7,-1,3), -2))
        assertEquals(0, test.countPairs(listOf(1), 2))
    }
}