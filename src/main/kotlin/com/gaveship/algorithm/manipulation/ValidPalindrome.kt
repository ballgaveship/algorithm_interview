package com.gaveship.algorithm.manipulation

import com.gaveship.algorithm.manipulation.ValidPalindrome.isPalindrome
import com.gaveship.algorithm.shouldBe
import java.util.*

/**
 * 01 유효한 팰린드롬
 *
 * 주어진 문자열이 팰린드롬인지 확인하라.
 * 대소문자를 구분하지 않으며, 영문자와 숫자만을 대상으로 한다.
 *
 * https://leetcode.com/problems/valid-palindrome
 *
 * 모든 대문자를 소문자로 변환하고 영문자와 숫자가 아닌 문자를 모두 제거한 후 앞뒤로 동일하게 읽는 경우 구는 회문 입니다.
 * 영숫자 문자에는 문자와 숫자가 포함됩니다.
 * 문자열이 회문 이면 true를 반환 하고 그렇지 않으면 false를 반환 합니다.
 */
object ValidPalindrome {
    /**
     * by regex
     */
//    fun isPalindrome(s: String): Boolean {
//        val regex = "[^a-zA-Z0-9]".toRegex()
//        val replaced = s.replace(regex, "")
//            .toLowerCase()
//        val reversed = replaced.reversed()
//        return replaced == reversed
//    }

    /**
     * by deque
     */
    fun isPalindrome(s: String): Boolean {
        val arrayDeque = ArrayDeque<Char>()
        s.forEach {
            if (it.isDigit() || it.isLetter()) {
                arrayDeque.add(it.toLowerCase())
            }
        }
        while (arrayDeque.isNotEmpty()) {
            if (arrayDeque.size <= 1) {
                break
            }
            if (arrayDeque.removeFirst() != arrayDeque.removeLast()) {
                return false
            }
        }
        return true
    }
}

fun main() {
    isPalindrome("A man, a plan, a canal: Panama") shouldBe true
    isPalindrome("race a car") shouldBe false
    isPalindrome(" ") shouldBe true
    isPalindrome("ab_a") shouldBe true
}