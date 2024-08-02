import java.util.*
import kotlin.math.abs

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
            for (j in i + 1..nums.size) {
                if (v + nums[j] < target) {
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
        var sum = (n + 1) * (2 * 0 + 1 * (n)) / 2
        for (i in nums) {
            sum -= i
        }
        return sum
    }

    //448
    //тк в ограничениях задачи нельзя использовать доп место,
    // будем помечать число по индексу отрицательным, если число, равное индексу, присутствует в массиве
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (i in nums.indices) {
            val v = abs(nums[i]) - 1
            nums[v] = abs(nums[v]) * -1
        }
        val l = mutableListOf<Int>()
        for (i in nums.indices) {
            if (nums[i] > 0) {
                l.add(i + 1)
            }
        }
        return l
    }
}