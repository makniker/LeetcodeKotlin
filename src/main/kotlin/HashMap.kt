import kotlin.collections.HashMap

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
}