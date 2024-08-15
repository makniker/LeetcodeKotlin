class Rotating {
    //189
    fun rotate(nums: IntArray, k: Int) {
        val ind = k % nums.size
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, ind - 1)
        reverse(nums, ind, nums.size - 1)
    }

    private fun reverse(nums: IntArray, lo: Int, hi: Int) {
        var fInd = lo
        var lInd = hi
        while (fInd < lInd) {
            val tmp = nums[fInd]
            nums[fInd++] = nums[lInd]
            nums[lInd--] = tmp
        }
    }
}