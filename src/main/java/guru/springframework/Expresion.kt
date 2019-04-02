package guru.springframework

interface Expresion {
    fun reduce(bank: Bank, to: String): Money
}
