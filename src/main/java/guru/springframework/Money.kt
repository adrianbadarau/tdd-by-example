package guru.springframework

open class Money(protected val amount: Int, protected val currency: String) {

    fun currency(): String {
        return currency
    }

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        if (amount != money.amount || !currency.equals(money.currency())) return false

        return true
    }

    open fun times(multiplier: Int): Money {
        return Money(amount * multiplier, currency)
    }

    override fun hashCode(): Int {
        return amount
    }

    companion object {
        fun dollar(amount: Int, currency: String = "USD"): Money {
            return Dollar(amount, currency)
        }

        fun franc(amount: Int, currency: String = "CHF"): Money {
            return Franc(amount, currency)
        }
    }

}
