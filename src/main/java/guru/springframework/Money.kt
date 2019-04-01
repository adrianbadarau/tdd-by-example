package guru.springframework

abstract class Money(protected val amount: Int) {

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
        fun dollar(amount: Int): Money {
            return Dollar(amount)
        }

        fun franc(amount: Int): Money {
            return Franc(amount)
        }
    }

}
