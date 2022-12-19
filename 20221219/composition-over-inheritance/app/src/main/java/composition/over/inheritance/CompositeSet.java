package composition.over.inheritance;

import java.util.Collection;
import java.util.Set;

public class CompositeSet<E> {
    private final Set<E> set;
    private int addCount = 0;

    public CompositeSet(Set<E> set) {
        this.set = set;
    }

    public void addAll(Collection<? extends E> elements) {
        addCount += elements.size();
        set.addAll(elements);
    }

    public int getAddedCount() {
        return addCount;
    }
}
