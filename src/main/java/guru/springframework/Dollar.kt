package guru.springframework

/**
 * Created by jt on 2018-10-04.
 */
class Dollar(var amount: Int) {

    fun times(multiplier: Int) {
        amount *= multiplier
    }
}
