package com.gaveship.algorithm.manipulation

import com.gaveship.algorithm.manipulation.ReverseString.reverseString

/**
 * 02 문자열 뒤집기
 *
 * 문자열을 뒤집는 함수를 작성하라.
 * 입력값은 문자 배열이며, 리턴 없이 리스트 내부를 직접 조작하라.
 *
 * https://leetcode.com/problems/reverse-string
 */
object ReverseString {
    /**
     * two pointer
     */
//    fun reverseString(s: CharArray): Unit {
//        var temp: Char
//        val size = s.size - 1
//        for (i in 0 .. size / 2) {
//            temp = s[i]
//            s[i] = s[size - i]
//            s[size - i] = temp
//        }
//        println(s)
//    }

    fun reverseString(s: CharArray): Unit {
        s.reverse()
        println(s)
    }
}

fun main() {
    reverseString(charArrayOf('h', 'e', 'l', 'l', 'o'))
    reverseString(charArrayOf('H','a','n','n','a','h'))
    reverseString(charArrayOf('A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'))
}