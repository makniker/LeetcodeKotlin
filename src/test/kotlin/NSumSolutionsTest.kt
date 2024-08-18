import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NSumSolutionsTest {
    private val test = NSumSolutions()
    @Test
    fun testTwoSumBinary() {
        assertTrue(intArrayOf(1, 2) contentEquals test.twoSumBinary(intArrayOf(2,7,11,15), 9))
    }

    @Test
    fun test3Sum() {
        println(test.threeSum(intArrayOf(-1,0,1,2,-1,-4)))
    }
}