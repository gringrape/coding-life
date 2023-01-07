/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package pairs

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AppTest {

    private fun numPairsDivisibleBy60(time: IntArray): Int {
        val remainders = time.map { it % 60 }

        val record = mutableMapOf<Int, Int>()

        var pairCount = 0
        remainders.forEach { i ->
            val count = record.getOrDefault((60 - i) % 60, 0)
            record.putIfAbsent(i, 0)
            record.computeIfPresent(i) { _, v -> v + 1 }
            pairCount += count
        }

        return pairCount
    }

    @Test fun testNumPairsDivisibleBy60() {
        assertEquals(3, numPairsDivisibleBy60(intArrayOf(30, 20, 150, 100, 40)))
        assertEquals(3, numPairsDivisibleBy60(intArrayOf(0, 0, 0)))
    }

}
