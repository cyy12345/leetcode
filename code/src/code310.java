import java.util.*;

//The solution here is spending too much time
class code310 {
    public  List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = -1;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            distances[edges[i][0]][edges[i][1]] = 1;
            distances[edges[i][1]][edges[i][0]] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distances[i][j] >0) {
                    for (int k = 0; k < n; k++) {
                        if (distances[j][k] > 0 ) {
                            if(distances[i][k]==-1 || distances[i][k] > distances[i][j] + distances[j][k]) {
                                distances[i][k] = distances[i][j] + distances[j][k];
                            }
                        }
                    }
                }
                distances[j][i] = distances[i][j];
            }
        }

        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    if (distances[i][j] > max[i]) {
                        max[i] = distances[i][j];
                    }
                }
            }
        }
        LinkedList<Integer> root = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (max[i] <= min) {
                min = max[i];
                System.out.println(min);
            }
        }
        for (int i = 0; i < n; i++) {
            if (max[i] == min) {
                System.out.println(i);
                root.add(i);
            }
        }
        return root;

    }
}

/**
 * This solution is in the Discuss district.
 *

 Our problem want us to find the minimum height trees and return their root labels. First we can think about a simple case -- a path graph.

 For a path graph of n nodes, find the minimum height trees is trivial. Just designate the middle point(s) as roots.

 Despite its triviality, let design a algorithm to find them.

 Suppose we don't know n, nor do we have random access of the nodes. We have to traversal. It is very easy to get the idea of two pointers. One from each end and move at the same speed. When they meet or they are one step away, (depends on the parity of n), we have the roots we want.

 This gives us a lot of useful ideas to crack our real problem.

 For a tree we can do some thing similar. We start from every end, by end we mean vertex of degree 1 (aka leaves). We let the pointers move the same speed. When two pointers meet, we keep only one of them, until the last two pointers meet or one step away we then find the roots.

 It is easy to see that the last two pointers are from the two ends of the longest path in the graph.

 The actual implementation is similar to the BFS topological sort. Remove the leaves, update the degrees of inner vertexes. Then remove the new leaves. Doing so level by level until there are 2 or 1 nodes left. What's left is our answer!

 The time complexity and space complexity are both O(n).

 Note that for a tree we always have V = n, E = n-1.
 */

class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}