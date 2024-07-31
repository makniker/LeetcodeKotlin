import kotlin.math.max
import kotlin.math.min

class BinarySearch {
    fun searchOne(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        while (start <= end) {
            val mid = (end - start) / 2 + start
            val midVal = nums[mid]
            if (midVal > target) {
                end = mid - 1
            } else if (midVal < target) {
                start = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }

    fun lowerBound(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size - 1
        var ans = nums.size
        while (lo <= hi) {
            var mi = lo + (hi - lo) / 2
            if (nums[mi] < target) {
                lo = mi + 1
            } else {
                ans = mi
                hi = mi - 1
            }
        }
        return ans
    }

    fun upperBound(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size - 1
        var ans = -1
        while (lo <= hi) {
            var mi = lo + (hi - lo) / 2
            if (nums[mi] <= target) {
                lo = mi + 1
            } else {
                ans = mi
                hi = mi - 1
            }
        }
        return ans
    }

    fun firstOne(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size - 1
        var ans = -1
        while (lo <= hi) {
            var mi = lo + (hi - lo) / 2
            if (nums[mi] < target) {
                lo = mi + 1
            } else if (nums[mi] == target){
                ans = mi
                hi = mi - 1
            } else {
                hi = mi - 1
            }
        }
        return ans
    }

    fun lastOne(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size - 1
        var ans = -1
        while (lo <= hi) {
            var mi = lo + (hi - lo) / 2
            if (nums[mi] <= target) {
                lo = mi + 1
            } else if (nums[mi] == target){
                ans = mi
                lo = mi + 1
            } else {
                hi = mi - 1
            }
        }
        return ans
    }


    fun searchOneRec(nums: IntArray, target: Int, lo: Int, hi: Int): Int {
        if (lo > hi) {
            return -1
        }
        val mid = lo + (hi - lo) / 2
        if (nums[mid] < target) {
            return searchOneRec(nums, target, mid + 1, hi)
        } else if (nums[mid] > target) {
            return searchOneRec(nums, target, lo, mid - 1)
        }
        return mid
    }

    fun lowerBoundRec(nums: IntArray, target: Int, lo: Int, hi: Int): Int {
        if (lo > hi) return nums.size
        val mid = lo + (hi - lo) / 2
        if (nums[mid] < target) return lowerBoundRec(nums, target, mid + 1, hi)
        val l = lowerBoundRec(nums, target, lo, mid - 1 )
        return min(mid, l)
    }

    //элемент за таргетом
    private fun upperBoundRec(nums: IntArray, target: Int, lo: Int, hi: Int): Int {
        if (lo > hi) return Int.MIN_VALUE
        val mid = lo + (hi - lo) / 2
        if (nums[mid] <= target) return upperBoundRec(nums, target, mid + 1, hi)
        return max(mid, upperBoundRec(nums, target, lo, mid - 1 ))
    }

    fun firstOneRec(nums: IntArray, target: Int, lo: Int, hi: Int): Int {
        if (lo > hi) return Int.MIN_VALUE
        val mid = lo + (hi - lo) / 2
        if (nums[mid] < target) return firstOneRec(nums, target, mid + 1, hi)
        else if (nums[mid] > target) return firstOneRec(nums, target, lo, mid - 1)
        return min(mid, firstOneRec(nums, target, lo, mid - 1))
    }

    fun lastOneRec(nums: IntArray, target: Int, lo: Int, hi: Int): Int {
        if (lo > hi) return Int.MIN_VALUE
        val mid = lo + (hi - lo) / 2
        if (nums[mid] < target) return lastOneRec(nums, target, mid + 1, hi)
        else if (nums[mid] > target) return lastOneRec(nums, target, lo, mid - 1)
        return max(mid, lastOneRec(nums, target, mid+1, hi ))
    }

    fun targetIndices(nums: IntArray, target: Int): List<Int> {
        nums.sort()

        return emptyList()
    }

    //найти краний правый отрицательный индекс
    //найти крайний левый положительный индекс
    fun maximumCount(nums: IntArray): Int {
        var negInd = lastNegativeRec(nums, 0, nums.size - 1)
        var i = if (negInd == -1) 0 else negInd
        negInd++
        while (nums[i] <= 0 && i < nums.size - 1) {
            i++
        }
        var posNum = if (i == nums.size - 1) 0 else nums.size - i
        return if (negInd > posNum) negInd else posNum
    }

    fun lastNegativeRec(nums: IntArray, lo: Int, hi:Int): Int {
        if(lo > hi) return -1
        val mid = lo + (hi - lo) / 2
        if (nums[mid] >= 0) return lastNegativeRec(nums, lo, mid - 1)
        return max(mid, lastNegativeRec(nums, mid + 1, hi))
    }
}