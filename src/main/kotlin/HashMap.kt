import kotlin.collections.HashMap
import kotlin.math.abs

class Hash {
    //217
    fun containsDuplicate(nums: IntArray): Boolean {
        val m = HashMap<Int, Int>()
        for (i in nums) {
            if (m.contains(i)) {
                return true
            }
            m[i] = m.getOrDefault(i, 0) + 1
        }
        return false
    }

    //219
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val m = HashMap<Int, Int>()
        for (i in nums.indices) {
            if(m.contains(nums[i])) {
                if (abs(m[nums[i]]!! - i) <= k ) {
                    return true
                }
            }
            m[nums[i]] = i
        }
        return false
    }
}