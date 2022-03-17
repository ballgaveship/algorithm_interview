package com.gaveship.algorithm

import com.gaveship.algorithm.ReverseString.reverseString

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