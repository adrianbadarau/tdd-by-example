package guru.springframework

open class Money(protected val amount: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Money) return false

        if (amount != other.amount) return false

        return true
    }

    override fun hashCode(): Int {
        return amount
    }

}
