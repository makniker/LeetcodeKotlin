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
        var j = word.indexOfFirst { it == ch }
        return word.replaceRange(0, j + 1, word.substring(0, j + 1).reversed())
    }
}