import java.util.*
import kotlin.math.abs


class TwoPointers {
    //88
    //идем в обратном порядке, смотрим на индекс второго массива
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var k = n + m - 1
        while (j >= 0) {
            nums1[k--] = if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[i--]
            } else {
                nums2[j--]
            }
        }
    }

    //простое слияние массивов
    fun merge(list1: MutableList<Int>, list2: MutableList<Int>): List<Int> {
        var i = 0
        var j = 0
        val list = mutableListOf<Int>()
        while (i < list1.size && j < list2.size) {
            if (list1[i] > list2[j]) {
                list.add(list2[j])
                j++
            } else {
                list.add(list1[i])
                i++
            }
        }
        while (i < list1.size) {
            list.add(list1[i])
            i++
        }
        while (j < list2.size) {
            list.add(list2[j])
            j++
        }
        return list
    }

    //2000
    fun reversePrefix(word: String, ch: Char): String {
        val j = word.indexOfFirst { it == ch }
        return word.replaceRange(0, j + 1, word.substring(0, j + 1).reversed())
    }

    //26
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        var j = 0
        var endOfFilteredArr = 0
        while (i < nums.size) {
            nums[endOfFilteredArr] = nums[i]
            while (j < nums.size && nums[j] == nums[i]) {
                j++
            }
            endOfFilteredArr++
            i = j
        }
        return endOfFilteredArr
    }

    //283
    fun moveZeroes(nums: IntArray) {
        var realArrInd = 0
        var i = 0
        var j = 0
        while (i < nums.size) {
            if (j >= nums.size) return
            while (nums[j] == 0) {
                j++
                if (j == nums.size) return
            }
            i = j
            if (nums[realArrInd] == 0) {
                nums[realArrInd++] = nums[i]
                nums[i] = 0
            } else {
                nums[realArrInd++] = nums[i]
            }
            j++
        }
    }

    //80
    fun removeDuplicates80(nums: IntArray): Int {
        var k = 0
        var i = 0
        while (i < nums.size) {
            while (i < nums.size && nums[i] == nums[k]) {
                if (abs(i - k) > 1) {
                    nums[i] = Int.MIN_VALUE
                }
                i++
            }
            k = i
        }
        var realArrInd = 0
        i = realArrInd + 1
        while (i < nums.size) {
            if (nums[i] != Int.MIN_VALUE) {
                realArrInd++
                nums[realArrInd] = nums[i]
                if (realArrInd != i) nums[i] = Int.MIN_VALUE
            }
            i++
        }
        return realArrInd + 1
    }

    //125
    fun isPalindrome(s: String): Boolean {
        if (s.length < 2) {
            return true
        }
        var i = 0
        var j = s.length - 1
        while (i <= j) {
            while (!s[i].isLetterOrDigit()) {
                i++
                if (i > s.length - 1) {
                    return true
                }
            }
            while (!s[j].isLetterOrDigit()) {
                j--
                if (j < 0) {
                    return true
                }
            }
            if (s[i++].lowercaseChar() != s[j--].lowercaseChar()) {
                return false
            }
        }
        return true
    }

    //392
    fun isSubsequence(s: String, t: String): Boolean {
        if (t.length < s.length) {
            return false
        }
        var j = 0
        for (i in s.indices) {
            if (j > t.length - 1) {
                return false
            }
            while (t[j] != s[i]) {
                j++
                if (j > t.length - 1) {
                    return false
                }
            }
            j++
        }
        return true
    }

    //3194
    fun minimumAverage(nums: IntArray): Double {
        var minVal = Int.MAX_VALUE
        nums.sort()
        for (i in 0..(nums.size / 2)) {
            val av = (nums[i] + nums[nums.size - 1 - i])
            if (av < minVal) {
                minVal = av
            }
        }
        return minVal.toDouble() / 2
    }

    //524
    fun findLongestWord(s: String, dictionary: List<String>): String {
        val newDict = dictionary.sortedWith(Comparator.comparingInt(String::length).reversed().thenComparing(String::toString))
        for (word in newDict) {
            var i = 0
            for (ch in s)
                if (i < word.length && ch == word[i]) i++
                if (i == word.length) return word
        }
        return ""
    }
}