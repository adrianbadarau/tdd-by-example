package guru.springframework

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals

/**
 * Created by jt on 2018-10-04.
 */
class MoneyTest {

    @Test
    internal fun testMultiplication() {
        val five = Money.dollar(5)
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
        val fiveF = Money.franc(5)
        assertEquals(Money.franc(10), fiveF.times(2))
        assertEquals(Money.franc(15), fiveF.times(3))
    }

    @Test
    internal fun testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5))
        assertNotEquals(Money.dollar(5), Money.dollar(15))
        assertNotEquals(Money.dollar(5), Money.franc(5))
        assertEquals(Money.franc(5), Money.franc(5))
        assertNotEquals(Money.franc(5), Money.franc(15))
    }

    @Test
    internal fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency())
        assertEquals("CHF", Money.franc(1).currency())
    }

    @Test
    internal fun testSimpleAddition() {
        val five = Money.dollar(5)
        val sum = five.plus(five)
        val bank = Bank()
        val reduced = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }

    @Test
    internal fun testPlusReturnsSum() {
        val five = Money.dollar(5)
        val sum = five.plus(five) as Sum
        assertEquals(five, sum.augment)
        assertEquals(five, sum.addmend)
    }

    @Test
    internal fun testReduceSum() {
        val sum = Sum(Money.dollar(3), Money.dollar(4))
        val result = Bank().reduce(sum, "USD")
        assertEquals(Money.dollar(7), result)
    }

    @Test
    internal fun testReduceMoney() {
        val result = Bank().reduce(Money.dollar(1), "USD")
        assertEquals(result, Money.dollar(1))
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(Money.franc(2), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
        assertEquals(1, Bank().rate("CHF", "CHF"))
    }

    @Test
    fun testMixedAddition() {
        val fiveBucks = Money.dollar(5)
        val tenFrancs = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(fiveBucks.plus(tenFrancs), "USD")
        assertEquals(Money.dollar(10), result)
    }

    @Test
    fun testSumPlusMoney() {
        val fiveBucks = Money.dollar(5)
        val tenFrancs = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val sum = Sum(fiveBucks, tenFrancs).plus(fiveBucks)
        val result = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(15), result)
    }

    @Test
    fun testSumTimes(){
        val fiveBucks = Money.dollar(5)
        val tenFrancs = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val sum = Sum(fiveBucks, tenFrancs).times(2)
        val result = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(20), result)
    }
}
