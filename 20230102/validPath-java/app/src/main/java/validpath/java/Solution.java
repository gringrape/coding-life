package validpath.java;

public class Solution {
    private final DisjointSet disjointSet;

    public Solution(DisjointSet disjointSet) {
        this.disjointSet = disjointSet;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        disjointSet.init(n);

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            disjointSet.union(start, end);
        }

        return disjointSet.isConnected(source, destination);
    }
}
