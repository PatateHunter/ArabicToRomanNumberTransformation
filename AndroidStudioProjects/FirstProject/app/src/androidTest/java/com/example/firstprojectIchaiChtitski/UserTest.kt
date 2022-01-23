package com.example.firstprojectIchaiChtitski

import junit.framework.TestCase
import org.junit.Test

class UserTest : TestCase(){
    @Test
    fun should_return_true_given_2_user_with_sames_attributes(){
        var user1 = User("Chtitski","Ichaï")
        var user2 = User("Chtitski","Ichaï")
        assertEquals(user1,user2)
    }


}

