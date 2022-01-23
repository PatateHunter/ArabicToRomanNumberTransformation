package com.example.firstprojectIchaiChtitski

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var user1 = User("yo","lo")
        var user2 = User("yo","lo")

        assertEquals(user1,user2)
    }
}