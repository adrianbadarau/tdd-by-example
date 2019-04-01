package guru.springframework

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals

/**
 * Created by jt on 2018-10-04.
 */
class MoneyTest {

    @Test
    internal fun testMultiplication() {
        val five = Dollar(5)
        five.times(2)
        assertEquals(10, five.amount)

    }
}
