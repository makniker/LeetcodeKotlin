import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BinarySearchTest {

    private val binarySearch = BinarySearch()

    @Test
    fun testSearchOne() {
        //ищем индекс определенного значения
        var nums = intArrayOf(-100, -27, 0, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.searchOne(nums, -100))
        assertEquals(3, binarySearch.searchOne(nums, 4))
        assertEquals(-1, binarySearch.searchOne(nums, 300))
        assertEquals(-1, binarySearch.searchOne(nums, -1000))
        assertEquals(-1, binarySearch.searchOne(nums, 30))
    }

    @Test
    fun testSearchOneRec() {
        var nums = intArrayOf(-100, -27, 0, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.searchOneRec(nums, -100, 0, nums.size - 1))
        assertEquals(3, binarySearch.searchOneRec(nums, 4, 0, nums.size - 1))
        assertEquals(-1, binarySearch.searchOneRec(nums, 300, 0, nums.size-1))
        assertEquals(-1, binarySearch.searchOneRec(nums, -1000, 0, nums.size-1))
        assertEquals(-1, binarySearch.searchOneRec(nums, 30, 0, nums.size-1))
    }

    @Test
    fun testLowerBound() {
        //ищем индекс, наилучше удовлетворяющий условию - даже если число не равно искомому. Если число за пределами массива, возвращаем его размер
        var nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.lowerBound(nums, -100))
        assertEquals(6, binarySearch.lowerBound(nums, 4))
        assertEquals(nums.size, binarySearch.lowerBound(nums, 300))
        assertEquals(0, binarySearch.lowerBound(nums, -1000))
        assertEquals(11, binarySearch.lowerBound(nums, 30))
    }

    @Test
    fun testLowerBoundRec() {
        var nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.lowerBoundRec(nums, -100, 0, nums.size - 1))
        assertEquals(6, binarySearch.lowerBoundRec(nums, 4, 0, nums.size - 1))
        assertEquals(nums.size, binarySearch.lowerBoundRec(nums, 300, 0, nums.size - 1))
        assertEquals(0, binarySearch.lowerBoundRec(nums, -1000, 0, nums.size - 1))
        assertEquals(11, binarySearch.lowerBoundRec(nums, 30, 0, nums.size - 1))
    }

    @Test
    fun targetIndices() {
        assertEquals(listOf(1, 2), binarySearch.targetIndices(intArrayOf(1,2,5,2,3), 2))
        assertEquals(listOf(3), binarySearch.targetIndices(intArrayOf(1,2,5,2,3), 3))
        assertEquals(listOf(4), binarySearch.targetIndices(intArrayOf(1,2,5,2,3), 5))
        assertEquals(listOf(1, 2), binarySearch.targetIndices(intArrayOf(1,2,5,2,3), 2))
        assertEquals(emptyList<Int>(), binarySearch.targetIndices(intArrayOf(1), 2))
    }

    @Test
    fun maximumCount() {
        var nums = intArrayOf(-2,-1,-1,1,2,3)
        assertEquals(3, binarySearch.maximumCount(nums))
        nums = intArrayOf(-2,-1,-1,0,0,1,2,3)
        assertEquals(3, binarySearch.maximumCount(nums))
        nums = intArrayOf(-2,-1,-1,0,0,1,2,3,4,5)
        assertEquals(5, binarySearch.maximumCount(nums))
        nums = intArrayOf(0, 0, 0, 0)
        assertEquals(0, binarySearch.maximumCount(nums))
        nums = intArrayOf(-4, -3, -2, -1)
        assertEquals(4, binarySearch.maximumCount(nums))
        nums = intArrayOf(-3,-2,-1,0,0,1,2)
        assertEquals(3, binarySearch.maximumCount(nums))
    }
}