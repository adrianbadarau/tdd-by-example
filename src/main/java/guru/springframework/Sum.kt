package guru.springframework

class Sum(val augment: Expresion, val addmend: Expresion) : Expresion {
    override fun reduce(bank: Bank, to: String): Money {
        val amount = augment.reduce(bank, to).getAmmount() + addmend.reduce(bank, to).getAmmount()
        return Money(amount, to)
    }

    override fun plus(addend: Expresion): Expresion {
        return Sum(this, addend)
    }

    override fun times(multiplier: Int): Expresion {
        return Sum(augment.times(multiplier), addmend.times(multiplier))
    }
}
