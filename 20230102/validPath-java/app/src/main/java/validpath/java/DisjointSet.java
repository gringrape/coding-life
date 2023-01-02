package validpath.java;

public interface DisjointSet {
    void init(int nodeCount);

    boolean isConnected(int source, int destination);

    void union(int start, int end);
}
