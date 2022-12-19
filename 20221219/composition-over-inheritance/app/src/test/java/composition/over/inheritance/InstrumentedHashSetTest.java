/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package composition.over.inheritance;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstrumentedHashSetTest {
    @Test
    void countAddedElements() {
        InstrumentedHashSet<Integer> set = new InstrumentedHashSet<>();
        set.addAll(List.of(1, 2, 3));
        assertEquals(3, set.getAddCount());
    }
}
