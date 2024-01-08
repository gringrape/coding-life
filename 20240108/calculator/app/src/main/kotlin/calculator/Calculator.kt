package calculator

class Calculator {
    fun evaluate(expression: String): Int {
        val (first, operator, second) = lex(expression)

        if (first !is NumberToken || second !is NumberToken || operator !is OperatorToken) {
            throw Error("Lexical analysis error")
        }

        return reduce(operator, first, second)
    }

    private fun reduce(operator: OperatorToken, first: NumberToken, second: NumberToken): Int {
        return operator.reduce(first, second)
    }

    fun lex(expression: String): List<Token> {
        return Regex("([+*-/])|(\\d+)")
            .findAll(expression)
            .map { it.value }
            .map {
                if (isNumberString(it)) NumberToken(it.toInt())
                else OperatorToken(it)
            }
            .toList()
    }

    private fun isNumberString(string: String): Boolean {
        return string.toIntOrNull() != null
    }
}
