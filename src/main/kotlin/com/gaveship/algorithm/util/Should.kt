package com.gaveship.algorithm.util

infix fun <T, U : T> T.shouldBe(expected: U?) {
    if (this is Array<*>) {
        expected as Array<*>
        this.forEachIndexed { index, data ->
            if (data != expected[index]) {
                throw IllegalArgumentException()
            }
        }
    } else {
        if (this != expected) {
            throw IllegalArgumentException("expect $expected but $this")
        }
    }
}