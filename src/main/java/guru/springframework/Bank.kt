package guru.springframework

class Bank {
    private val rateMap = hashMapOf<Pair, Int>()
    fun reduce(source: Expresion, toCurrency: String): Money {
        return source.reduce(this, toCurrency)
    }

    fun rate(from: String, to: String): Int {
        if (from.equals(to)) return 1
        return rateMap[Pair(from, to)] ?: 0
    }

    fun addRate(from: String, to: String, rate: Int) {
        rateMap[Pair(from, to)] = rate
    }
}
