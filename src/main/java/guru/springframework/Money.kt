package guru.springframework

open class Money(protected val amount: Int, protected val currency: String) : Expresion {

    fun currency(): String {
        return currency
    }

    fun getAmmount(): Int {
        return amount
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

    fun plus(addend: Money): Expresion {
        return Sum(this, addend)
    }

    companion object {
        fun dollar(amount: Int, currency: String = "USD"): Money {
            return Money(amount, currency)
        }

        fun franc(amount: Int, currency: String = "CHF"): Money {
            return Money(amount, currency)
        }
    }

    override fun reduce(to:String):Money{
        return this
    }

}
