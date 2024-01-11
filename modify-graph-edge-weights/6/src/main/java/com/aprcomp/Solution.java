package com.aprcomp;
import java.util.*;
/**java 
 You are given an undirected weighted connected graph containing n nodes labeled from 0 to n - 1, and an integer array edges where edges[i] = [ai, bi, wi] indicates that there is an edge between nodes ai and bi with weight wi.
Some edges have a weight of -1 (wi = -1), while others have a positive weight (wi > 0).
Your task is to modify all edges with a weight of -1 by assigning them positive integer values in the range [1, 2 * 10 ** 9] so that the shortest distance between the nodes source and destination becomes equal to an integer target. If there are multiple modifications that make the shortest distance between source and destination equal to target, any of them will be considered correct.
Return an array containing all edges (even unmodified ones) in any order if it is possible to make the shortest distance from source to destination equal to target, or an empty array if it's impossible.
Note: You are not allowed to modify the weights of edges with initial positive weights.
 
Example 1:


Input: n = 5, edges = [[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]], source = 0, destination = 1, target = 5
Output: [[4,1,1],[2,0,1],[0,3,3],[4,3,1]]
Explanation: The graph above shows a possible modification to the edges, making the distance from 0 to 1 equal to 5.

Example 2:


Input: n = 3, edges = [[0,1,-1],[0,2,5]], source = 0, destination = 2, target = 6
Output: []
Explanation: The graph above contains the initial edges. It is not possible to make the distance from 0 to 2 equal to 6 by modifying the edge with weight -1. So, an empty array is returned.

Example 3:


Input: n = 4, edges = [[1,0,4],[1,2,3],[2,3,5],[0,3,-1]], source = 0, destination = 2, target = 6
Output: [[1,0,4],[1,2,3],[2,3,5],[0,3,1]]
Explanation: The graph above shows a modified graph having the shortest distance from 0 to 2 as 6.

 
Constraints:

1 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= ai, bi < n
wi = -1 or 1 <= wi <= 10 ** 7
ai != bi
0 <= source, destination < n
source != destination
1 <= target <= 10 ** 9
The graph is connected, and there are no self-loops or repeated edges

 **/
class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        // Create a map to store the edge weights
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(u).put(v, w);
            graph.get(v).put(u, w);
        }

        // Create a priority queue to store the nodes with their shortest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        // Create an array to store the shortest distance from source to each node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Create an array to store the previous node in the shortest path
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];

            if (distance > dist[node]) {
                continue;
            }

            if (node == destination && distance == target) {
                break;
            }

            Map<Integer, Integer> neighbors = graph.get(node);
            for (int neighbor : neighbors.keySet()) {
                int weight = neighbors.get(neighbor);

                if (weight == -1) {
                    weight = 1;
                }

                int newDistance = distance + weight;

                if (newDistance < dist[neighbor]) {
                    dist[neighbor] = newDistance;
                    prev[neighbor] = node;
                    pq.offer(new int[]{neighbor, newDistance});
                }
            }
        }

        // Check if a path from source to destination with the target distance exists
        if (prev[destination] == -1 || dist[destination] != target) {
            return new int[0][0];
        }

        // Reconstruct the modified edges
        List<int[]> modifiedEdges = new ArrayList<>();
        for (int v = destination; v != source; v = prev[v]) {
            int u = prev[v];
            int w = graph.get(u).get(v);

            if (w == -1) {
                w = target - dist[destination] + dist[u];
            }

            modifiedEdges.add(new int[]{u, v, w});
        }

        // Reverse the modified edges
        Collections.reverse(modifiedEdges);

        // Convert the modified edges to an array
        int[][] result = new int[modifiedEdges.size()][3];
        for (int i = 0; i < modifiedEdges.size(); i++) {
            result[i] = modifiedEdges.get(i);
        }

        return result;
    }
}