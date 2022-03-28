package com.gaveship.algorithm.manipulation

/**
 * 05 그룹 애너그램
 *
 * 문자열 배열을 받아 애너그램 단위로 그룹핑하라.
 *
 * https://leetcode.com/problems/group-anagrams/
 */
object GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagrams = mutableMapOf<String, MutableList<String>>()
        strs.forEach {
            val sortedString = it.toCharArray().sorted().joinToString("")
            val sameStringList = anagrams[sortedString]
            if (sameStringList == null) {
                anagrams[sortedString] = mutableListOf(it)
            } else {
                sameStringList.add(it)
            }
        }
        return anagrams.map { it.value }
    }
}

fun main() {
    GroupAnagrams.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
}