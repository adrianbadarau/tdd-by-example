package guru.springframework

class Sum(val augment: Expresion, val addmend: Expresion) : Expresion {
    override fun reduce(bank: Bank, to: String): Money {
        val amount = augment.reduce(bank, to).getAmmount() + addmend.reduce(bank, to).getAmmount()
        return Money(amount, to)
    }

    override fun plus(addend: Expresion): Expresion {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
