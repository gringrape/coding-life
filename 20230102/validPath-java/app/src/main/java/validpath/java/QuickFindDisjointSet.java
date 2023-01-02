package validpath.java;

import java.util.stream.IntStream;

public class QuickFindDisjointSet implements DisjointSet {
    private int[] ids;

    @Override
    public void init(int nodeCount) {
        this.ids = IntStream.range(0, nodeCount).toArray();
    }

    @Override
    public boolean isConnected(int source, int destination) {
        return ids[source] == ids[destination];
    }

    @Override
    public void union(int start, int end) {
        int unifyingId = ids[start];
        int removingId = ids[end];

        for (int i = 0; i < ids.length; i += 1) {
            if (ids[i] == removingId) {
                ids[i] = unifyingId;
            }
        }
    }
}
