package com.gaveship.algorithm

import com.gaveship.algorithm.ReorderDataInLogFiles.reorderLogFiles

/**
 * 03 로그 파일 재정렬
 *
 * 1. 로그의 가장 앞 부분은 식별자다.
 * 2. 문자로 구성된 로그가 숫자 로그보다 앞에 온다.
 * 3. 식별자는 순서에 영향을 끼치지 않지만, 문자가 동일할 경우 식별자 순으로 한다.
 * 4. 숫자 로그는 입력 순서대로 한다.
 *
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
object ReorderDataInLogFiles {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val digits = mutableListOf<String>()
        val letters = mutableListOf<String>()
        logs.forEach {
            val splitString = it.split(" ")
            if (isDigit(splitString[1].first())) {
                digits.add(it)
            } else {
                letters.add(it)
            }
        }
        digits.sorted()
        val comparator = Comparator<String> { o1, o2 ->
            val first = o1.split(" ", limit = 2)
            val second = o2.split(" ", limit = 2)
            if (first[1].compareTo(second[1]) == 0)
                first[0].compareTo(second[0])
            else
                first[1].compareTo(second[1])
        }
        return letters.sortedWith(comparator).toTypedArray() + digits.toTypedArray()
    }

    private fun isDigit(char: Char): Boolean = Character.isDigit(char)
}

fun main() {
    reorderLogFiles(arrayOf("dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero")) shouldBe arrayOf("let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6")
    reorderLogFiles(arrayOf("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo")) shouldBe arrayOf("g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7")
}