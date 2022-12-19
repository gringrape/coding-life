package composition.over.inheritance;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompositeHashSetTest {
    @Test
    void countAddedElement() {
        CompositeSet set = new CompositeSet(new HashSet<Integer>());

        set.addAll(List.of(1, 2, 3));

        assertEquals(3, set.getAddedCount());
    }
}