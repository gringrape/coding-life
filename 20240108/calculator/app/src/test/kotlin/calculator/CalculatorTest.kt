/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package calculator

import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {
    @Test
    fun testLex() {
        val calculator = Calculator()

        val tokens = calculator.lex("3+ 15")

        assertEquals(NumberToken(3), tokens[0])
        assertEquals(OperatorToken("+"), tokens[1])
        assertEquals(NumberToken(15), tokens[2])
    }

    @Test
    fun testOperations() {
        val calculator = Calculator()

        assertEquals(8, calculator.evaluate("3 + 5"))
        assertEquals(44, calculator.evaluate("4 * 11"))
        assertEquals(0, calculator.evaluate("11 - 11"))
        assertEquals(1, calculator.evaluate("11 / 11"))
    }
}
