class NSumSolutions {
    //167
    fun twoSumBinary(numbers: IntArray, target: Int): IntArray {
        for (i in 0..numbers.size - 2) {
            val t = target - numbers[i]
            var lo = i + 1
            var hi = numbers.size - 1
            while (lo <= hi) {
                val mid = lo + (hi - lo) / 2
                if (numbers[mid] < t) lo = mid + 1
                if (numbers[mid] > t) hi = mid - 1
                if (numbers[mid] == t) return intArrayOf(i + 1, mid + 1)
            }
        }
        return intArrayOf()
    }

    //15
    //сортируем список. Идем двумя указателями с конца и начала, сравниваем сумму с нулем
    fun threeSum(nums: IntArray): List<List<Int>> {
        val mapOfAnswers = HashSet<List<Int>>()
        nums.sort()
        for (i in nums.indices) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                val target = nums[i]
                var left = i + 1
                var right = nums.size - 1
                while (left < right) {
                    val sum = target + nums[left] + nums[right]
                    if (sum > 0) right--
                    else if (sum < 0) left++
                    else {
                        mapOfAnswers.add(listOf(target, nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--
                        left++
                        right--
                    }
                }
            }
        }

        return mapOfAnswers.toList()
    }

    //1
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val t = target - nums[i]
            if (map.contains(t)) {
                return intArrayOf(map[t]!!, i)
            }
            map[nums[i]] = i
        }
        return IntArray(1)
    }
}