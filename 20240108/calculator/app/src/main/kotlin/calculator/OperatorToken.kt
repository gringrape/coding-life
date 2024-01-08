package calculator

class OperatorToken(override val value: String) : Token() {
    fun reduce(first: NumberToken, second: NumberToken): Int =
        when(value) {
            "+" -> first.value + second.value
            "*" -> first.value * second.value
            "-" -> first.value - second.value
            "/" -> first.value / second.value
            else -> throw Error("Undefined operator")
        }
}
