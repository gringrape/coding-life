package calculator

abstract class Token {
    abstract val value: Any

    override fun equals(other: Any?): Boolean = (other is Token) && this.value == other.value
}
