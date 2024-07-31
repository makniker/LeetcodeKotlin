import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BinarySearchTest {

    private val binarySearch = BinarySearch()

    @Test
    fun testSearchOne() {
        //ищем индекс определенного значения
        val nums = intArrayOf(-100, -27, 0, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.searchOne(nums, -100))
        assertEquals(3, binarySearch.searchOne(nums, 4))
        assertEquals(-1, binarySearch.searchOne(nums, 300))
        assertEquals(-1, binarySearch.searchOne(nums, -1000))
        assertEquals(-1, binarySearch.searchOne(nums, 30))
    }

    @Test
    fun testSearchOneRec() {
        val nums = intArrayOf(-100, -27, 0, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.searchOneRec(nums, -100, 0, nums.size - 1))
        assertEquals(3, binarySearch.searchOneRec(nums, 4, 0, nums.size - 1))
        assertEquals(-1, binarySearch.searchOneRec(nums, 300, 0, nums.size - 1))
        assertEquals(-1, binarySearch.searchOneRec(nums, -1000, 0, nums.size - 1))
        assertEquals(-1, binarySearch.searchOneRec(nums, 30, 0, nums.size - 1))
    }

    @Test
    fun testLowerBound() {
        //ищем индекс, наилучше удовлетворяющий условию - меньше равен искомому. Если такого нет, возвращаем размер
        val nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.lowerBound(nums, -100))
        assertEquals(6, binarySearch.lowerBound(nums, 4))
        assertEquals(nums.size, binarySearch.lowerBound(nums, 300))
        assertEquals(0, binarySearch.lowerBound(nums, -1000))
        assertEquals(11, binarySearch.lowerBound(nums, 30))
    }

    @Test
    fun testLowerBoundRec() {
        val nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.lowerBoundRec(nums, -100, 0, nums.size - 1))
        assertEquals(6, binarySearch.lowerBoundRec(nums, 4, 0, nums.size - 1))
        assertEquals(nums.size, binarySearch.lowerBoundRec(nums, 300, 0, nums.size - 1))
        assertEquals(0, binarySearch.lowerBoundRec(nums, -1000, 0, nums.size - 1))
        assertEquals(11, binarySearch.lowerBoundRec(nums, 30, 0, nums.size - 1))
    }

    @Test
    fun testUpperBound() {
        // ищем индекс, удовлетворяющий условию - больше искомого
        val nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(4, binarySearch.upperBound(nums, -100))
        assertEquals(9, binarySearch.upperBound(nums, 4))
        assertEquals(nums.size, binarySearch.upperBound(nums, 300))
        assertEquals(0, binarySearch.upperBound(nums, -1000))
        assertEquals(11, binarySearch.upperBound(nums, 30))
    }

    @Test
    fun testUpperBoundRec() {
        val nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(4, binarySearch.upperBoundRec(nums, -100, 0, nums.size - 1))
        assertEquals(9, binarySearch.upperBoundRec(nums, 4, 0, nums.size - 1))
        assertEquals(nums.size, binarySearch.upperBoundRec(nums, 300, 0, nums.size - 1))
        assertEquals(0, binarySearch.upperBoundRec(nums, -1000, 0, nums.size - 1))
        assertEquals(11, binarySearch.upperBoundRec(nums, 30, 0, nums.size - 1))
    }

    @Test
    fun testLastOne() {
        //ищем последнее значение
        val nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(3, binarySearch.lastOne(nums, -100))
        assertEquals(8, binarySearch.lastOne(nums, 4))
        assertEquals(-1, binarySearch.lastOne(nums, 300))
        assertEquals(-1, binarySearch.lastOne(nums, -1000))
        assertEquals(-1, binarySearch.lastOne(nums, 30))
    }

    @Test
    fun testLastOneRec() {
        val nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(3, binarySearch.lastOneRec(nums, -100, 0, nums.size - 1))
        assertEquals(8, binarySearch.lastOneRec(nums, 4, 0, nums.size - 1))
        assertEquals(-1, binarySearch.lastOneRec(nums, 300, 0, nums.size - 1))
        assertEquals(-1, binarySearch.lastOneRec(nums, -1000, 0, nums.size - 1))
        assertEquals(-1, binarySearch.lastOneRec(nums, 30, 0, nums.size - 1))
    }

    @Test
    fun testFirstOne() {
        val nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.firstOne(nums, -100))
        assertEquals(6, binarySearch.firstOne(nums, 4))
        assertEquals(-1, binarySearch.firstOne(nums, 300))
        assertEquals(-1, binarySearch.firstOne(nums, -1000))
        assertEquals(-1, binarySearch.firstOne(nums, 30))
    }

    @Test
    fun testFirstOneRec() {
        val nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(0, binarySearch.firstOneRec(nums, -100, 0, nums.size - 1))
        assertEquals(6, binarySearch.firstOneRec(nums, 4, 0, nums.size - 1))
        assertEquals(Int.MAX_VALUE, binarySearch.firstOneRec(nums, 300, 0, nums.size - 1))
        assertEquals(Int.MAX_VALUE, binarySearch.firstOneRec(nums, -1000, 0, nums.size - 1))
        assertEquals(Int.MAX_VALUE, binarySearch.firstOneRec(nums, 30, 0, nums.size - 1))
    }

    @Test
    fun targetIndices() {
        assertEquals(listOf(1, 2), binarySearch.targetIndices(intArrayOf(1, 2, 5, 2, 3), 2))
        assertEquals(listOf(3), binarySearch.targetIndices(intArrayOf(1, 2, 5, 2, 3), 3))
        assertEquals(listOf(4), binarySearch.targetIndices(intArrayOf(1, 2, 5, 2, 3), 5))
        assertEquals(listOf(1, 2), binarySearch.targetIndices(intArrayOf(1, 2, 5, 2, 3), 2))
        assertEquals(emptyList<Int>(), binarySearch.targetIndices(intArrayOf(1), 2))
    }

    @Test
    fun testMaximumCount() {
        var nums = intArrayOf(-2, -1, -1, 1, 2, 3)
        assertEquals(3, binarySearch.maximumCount(nums))
        nums = intArrayOf(-2, -1, -1, 0, 0, 1, 2, 3)
        assertEquals(3, binarySearch.maximumCount(nums))
        nums = intArrayOf(-2, -1, -1, 0, 0, 1, 2, 3, 4, 5)
        assertEquals(5, binarySearch.maximumCount(nums))
        nums = intArrayOf(0, 0, 0, 0)
        assertEquals(0, binarySearch.maximumCount(nums))
        nums = intArrayOf(-4, -3, -2, -1)
        assertEquals(4, binarySearch.maximumCount(nums))
        nums = intArrayOf(-3, -2, -1, 0, 0, 1, 2)
        assertEquals(3, binarySearch.maximumCount(nums))
        nums = intArrayOf(0,0,1,2)
        assertEquals(2, binarySearch.maximumCount(nums))
    }

    @Test
    fun testFirstOnePosRec() {
        val nums = intArrayOf(-100, -100, -100, -100, -27, 0, 4, 4, 4, 8, 22, 45, 100)
        assertEquals(6, binarySearch.firstPositiveRec(nums, 0, nums.size - 1))
    }

    @Test
    fun testSpecialArray() {
        var nums = intArrayOf(3,5)
        assertEquals(2, binarySearch.specialArrayBinary(nums))
        nums = intArrayOf(0,0)
        assertEquals(-1, binarySearch.specialArrayBinary(nums))
        assertEquals(3, binarySearch.specialArrayBinary(intArrayOf(0,4,3,0,4)))
        assertEquals(1, binarySearch.specialArrayBinary(intArrayOf(1)))
    }
}