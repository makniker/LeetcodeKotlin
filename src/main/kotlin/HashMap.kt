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

    //220
    fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
        val m = HashMap<Int, Int>() // значение и индекс
        for (index in nums.indices) {
            for (t in nums[index]..(nums[index] + valueDiff)) {
                if(m.contains(t)) {
                    if (abs(m[t]!! - index) <= indexDiff ) {
                        return true
                    }
                }
            }
            for (t in (nums[index] - valueDiff)..nums[index]) {
                if (m.contains(t)) {
                    if (abs(m[t]!! - index) <= indexDiff ) {
                        return true
                    }
                }
            }
            m[nums[index]] = index
        }
        return false
    }
}