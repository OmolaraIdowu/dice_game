package com.swancodes.dicegame

import junit.framework.TestCase.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generates_number() {
        val firstDice = Dice(6)
        val rollResult = firstDice.roll()
        assertTrue( "The value of rollResult was not between 1 and 6", rollResult in 1..6)

        val secondDice = Dice(6)
        val rollResult2 = secondDice.roll()
        assertTrue( "The value of rollResult was not between 1 and 6", rollResult2 in 1..6)

        val thirdDice = Dice(6)
        val rollResult3 = thirdDice.roll()
        assertTrue( "The value of rollResult was not between 1 and 6", rollResult3 in 1..6)
    }
}