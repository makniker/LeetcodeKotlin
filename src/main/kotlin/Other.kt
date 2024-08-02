import java.util.*

class Other {
    fun isPalindrome(x: Int): Boolean {
        if (x >= 0) {
            val list = LinkedList<Int>()
            var curr = x
            while (curr != 0) {
                list.addLast(curr % 10)
                curr /= 10
            }
            while (list.size > 1) {
                if (list.pollFirst() != list.pollLast()) {
                    return false
                }
            }
            return true
        }
        return false
    }

    fun countPairs(nums: List<Int>, target: Int): Int {
        var count = 0
        for (i in nums.indices) {
            val v = nums[i]
            val next = nums.listIterator(i + 1)
            next.forEachRemaining {
                if (it + v < target) {
                    ++count
                }
            }
        }
        return count
    }

    fun countPairsSimple(nums: List<Int>, target: Int): Int {
        var count = 0
        for (i in nums.indices) {
            val v = nums[i]
           for (j in i+1..nums.size) {
               if (v + nums[j]<target) {
                   ++count
               }
           }
        }
        return count
    }

    //268
    //смотрим сумму ариф. прогрессии и вычитаем из нее все существующие номера в массиве
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        var sum = (n + 1) * (2 * 0 + 1*(n)) / 2
        for (i in nums) {
            sum -= i
        }
        return sum
    }
}