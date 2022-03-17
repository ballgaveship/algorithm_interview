package com.gaveship.algorithm

infix fun <T, U : T> T.shouldBe(expected: U?) {
    if (this != expected) {
        throw IllegalArgumentException()
    }
}