package guru.springframework

/**
 * Created by jt on 2018-10-04.
 */
data class Dollar(private val amount: Int) {

    fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }
}
