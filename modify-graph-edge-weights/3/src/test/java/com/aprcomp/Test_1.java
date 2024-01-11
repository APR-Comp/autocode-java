package com.aprcomp;

import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;

public class Test_1 {
    @Test(timeout = 5000)
    public void test_1() {
        int n = 3;
        int source = 0;
        int destination = 2;
        int target = 6;
        int[][] edges = new Solution().modifiedGraphEdges(n, new int[][] { { 0, 1, -1 }, { 0, 2, 5 } }, source,
                destination, target);


        assertTrue(edges.length == 0);

    }

    private void dijkstra(Map<Integer, Integer>[] adjs, int[] distTo, Queue<int[]> pq) {
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            for (Map.Entry<Integer, Integer> entry : adjs[curr[0]].entrySet()) {
                if (entry.getValue() > 0) {
                    int next = entry.getKey();
                    if (distTo[next] - entry.getValue() > distTo[curr[0]]) {
                        distTo[next] = distTo[curr[0]] + entry.getValue();
                        pq.add(new int[] { next, distTo[next] });
                    }
                }
            }
        }
    }
}