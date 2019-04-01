package guru.springframework

abstract class Money(protected val amount: Int, protected val currency: String) {

    fun currency(): String {
        return currency
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (this === other) return true
        if (other !is Money) return false
        if (this::class != other::class) return false

        if (amount != other.amount) return false

        return true
    }

    abstract fun times(multiplier: Int): Money

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
