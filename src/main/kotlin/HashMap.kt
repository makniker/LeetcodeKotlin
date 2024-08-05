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
    //берем бакеты ширины valueDiff, смотри, в какой бакет попадает число,
    // искомый сосед будет либо в этом бакете, либо в соседнем. Для соседних проверяем еще раз условия вхождения в valueDiff,
    //всегда держим последний вошедший индекс
    fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
        fun getBucketId(num: Int, bucketWidth: Int) = if (num > 0) num / bucketWidth else (num + 1) / bucketWidth - 1
        val m = HashMap<Int, Int>()
        val bucketWidth = valueDiff + 1
        for (index in nums.indices) {
            val numBucketId = getBucketId(nums[index], bucketWidth)
            if (m.containsKey(numBucketId)) return true
            else if (m.containsKey(numBucketId - 1) && nums[index] - m[numBucketId - 1]!! <= valueDiff) return true
            else if (m.containsKey(numBucketId + 1) && m[numBucketId + 1]!! - nums[index] <= valueDiff) return true
            m[numBucketId] = nums[index]
            if (index >= indexDiff) m.remove(getBucketId(nums[index - indexDiff], bucketWidth));
        }
        return false
    }
}