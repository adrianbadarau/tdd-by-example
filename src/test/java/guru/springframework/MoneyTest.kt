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
        val five = Money.dollar(5)
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    internal fun testEqualityDollar() {
        assertEquals(Money.dollar(5), Money.dollar(5))
        assertNotEquals(Money.dollar(5), Money.dollar(15))
        assertNotEquals(Money.dollar(5), Money.franc(5))
    }

    @Test
    internal fun testMultiplicationFranc() {
        val five = Money.franc(5)
        assertEquals(Money.franc(10), five.times(2))
        assertEquals(Money.franc(15), five.times(3))
    }

    @Test
    internal fun testEqualityFranc() {
        assertEquals(Money.franc(5), Money.franc(5))
        assertNotEquals(Money.franc(5), Money.franc(15))
    }

    @Test
    internal fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency())
        assertEquals("CHF", Money.franc(1).currency())
    }
}
