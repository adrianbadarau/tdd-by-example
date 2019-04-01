package guru.springframework

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals

/**
 * Created by jt on 2018-10-04.
 */
class MoneyTest {

    @Test
    internal fun testMultiplicationDollar() {
        val five = Dollar(5)
        var product = five.times(2)
        assertEquals(Dollar(10), product)
        product = five.times(3)
        assertEquals(Dollar(15), product)
    }

    @Test
    internal fun testEqualityDollar() {
        assertEquals(Dollar(5), Dollar(5))
        assertNotEquals(Dollar(5), Dollar(15))
        assertNotEquals(Dollar(5), Franc(5))
    }

    @Test
    internal fun testMultiplicationFranc() {
        val five = Franc(5)
        var product = five.times(2)
        assertEquals(Franc(10), product)
        product = five.times(3)
        assertEquals(Franc(15), product)
    }

    @Test
    internal fun testEqualityFranc() {
        assertEquals(Franc(5), Franc(5))
        assertNotEquals(Franc(5), Franc(15))
    }
}
