import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RotatingTest {
    private val r = Rotating()
    @Test
    fun testRotate() {
        var nums = intArrayOf(1,2,3,4,5,6,7)
        r.rotate(nums, 3)
        assertTrue(nums.myEquals(intArrayOf(5,6,7,1,2,3,4)))

        nums = intArrayOf(1,2,3,4,5,6,7)
        r.rotate(nums, 21)
        assertTrue(nums.myEquals(intArrayOf(1,2,3,4,5,6,7)))
    }
}