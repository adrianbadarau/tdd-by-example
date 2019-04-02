package guru.springframework

class Sum(val augment: Money, val addmend: Money) : Expresion {
    override fun reduce(to: String): Money {
        val amount = augment.getAmmount() + addmend.getAmmount()
        return Money(amount, to)
    }
}
