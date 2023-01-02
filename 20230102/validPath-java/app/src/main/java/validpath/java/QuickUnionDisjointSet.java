package validpath.java;

import java.util.stream.IntStream;

public class QuickUnionDisjointSet implements DisjointSet {
    private int[] ids;

    @Override
    public void init(int nodeCount) {
        this.ids = IntStream.range(0, nodeCount).toArray();
    }

    @Override
    public boolean isConnected(int source, int destination) {
        return root(source) == root(destination);
    }

    private int root(int source) {
        if (ids[source] == source) {
            return source;
        }
        return root(ids[source]);
    }

    @Override
    public void union(int start, int end) {
        ids[end] = ids[start];
    }
}
