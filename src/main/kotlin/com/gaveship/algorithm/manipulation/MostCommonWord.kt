package com.gaveship.algorithm.manipulation

import com.gaveship.algorithm.shouldBe

/**
 * 04 가장 흔한 단어
 *
 * 금지된 단어를 제외한 가장 흔하게 등장하는 단어를 출력하라.
 * 대소문자 구분을 하지 않으며, 구두점 (마침표, 쉼표) 또한 무시한다.
 *
 * https://leetcode.com/problems/most-common-word/
 */
object MostCommonWord {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val banMap = banned.associate {
            it to it
        }
        val regex = "[^\\w]".toRegex()
        val split = paragraph.split(" ", "!", "?", "'", ",", ";", ".")
        val wordMap = mutableMapOf<String, Int>()
        var maxCount = 0
        var maxCountWord = ""
        split.forEach {
            if (it == "") {
                return@forEach
            }

            val replacedWord = it.replace(regex, "")
                .toLowerCase()

            if (banMap[replacedWord] != null) {
                return@forEach
            }

            val count = wordMap[replacedWord]
            val cal = if (count == null) {
                1
            } else {
                count + 1
            }
            wordMap[replacedWord] = cal
            if (maxCount < cal) {
                maxCount = cal
                maxCountWord = replacedWord
            }
        }
        return maxCountWord
    }
}

fun main() {
//    MostCommonWord.mostCommonWord(
//        "Bob hit a ball, the hit BALL flew far after it was hit.",
//        arrayOf("hit")
//    ) shouldBe "ball"

    MostCommonWord.mostCommonWord(
        "Bob. hIt, baLl",
        arrayOf("bob", "hit")
    ) shouldBe "ball"
}