package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_1415        {
@Test(timeout=5000)
public void test_1415(){
int source =0    ;
int destination =16    ;
int target =1    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{4,6,356},new int[]{4,13,677},new int[]{6,15,892},new int[]{4,12,892},new int[]{13,5,892},new int[]{5,16,892},new int[]{12,10,892},new int[]{16,3,892},new int[]{10,8,892},new int[]{4,0,383},new int[]{8,18,892},new int[]{16,9,892},new int[]{18,17,892},new int[]{8,11,892},new int[]{9,7,892},new int[]{11,2,892},new int[]{18,19,703},new int[]{10,14,212},new int[]{19,1,-1},new int[]{0,14,252},new int[]{2,14,892},new int[]{19,17,892},new int[]{8,16,892},new int[]{1,1,892},new int[]{4,13,892},new int[]{2,5,892},new int[]{13,8,639},new int[]{5,16,7},new int[]{5,4,255},new int[]{15,16,252},new int[]{5,7,892},new int[]{3,13,892},new int[]{5,15,892},new int[]{5,8,892},new int[]{2,12,892},new int[]{0,17,892},new int[]{10,15,494},new int[]{0,11,892},new int[]{7,11,892},new int[]{7,4,892},new int[]{4,14,892},new int[]{7,9,892},new int[]{2,15,892},new int[]{15,3,892},new int[]{16,16,892},new int[]{17,12,383},new int[]{16,19,892},new int[]{15,14,892},new int[]{1,5,892},new int[]{1,1,892},new int[]{9,17,892},new int[]{5,7,892},new int[]{12,7,703},new int[]{0,16,212},new int[]{4,1,494},new int[]{10,19,892},new int[]{18,3,892},new int[]{16,17,892},new int[]{11,10,892},new int[]{5,9,894},new int[]{10,10,892},new int[]{15,3,892},new int[]{17,11,892},new int[]{19,12,892},new int[]{6,15,101},new int[]{13,1,-1},new int[]{14,5,-1},new int[]{2,17,-1},new int[]{16,19,-1},new int[]{10,1,-1},new int[]{16,5,-1},new int[]{2,14,-1},new int[]{17,18,-1},new int[]{15,14,-1},new int[]{13,9,-1},new int[]{19,17,-1},new int[]{15,13,-1},new int[]{19,11,-1},new int[]{11,11,-1},new int[]{16,19,-1},new int[]{15,12,-1},new int[]{14,11,-1},new int[]{9,17,-1},new int[]{11,13,-1},new int[]{13,18,-1},new int[]{7,15,-1},new int[]{15,1,-1},new int[]{8,15,-1},new int[]{16,15,-1},new int[]{18,7,-1},new int[]{15,9,-1},new int[]{13,1,-1},new int[]{4,18,-1},new int[]{1,13,-1},new int[]{19,6,-1},new int[]{9,4,-1},new int[]{15,17,-1},new int[]{18,18,-1},new int[]{19,16,-1},new int[]{2,10,-1},new int[]{1,19,-1},new int[]{9,10,-1},new int[]{6,15,-1},new int[]{0,5,-1},new int[]{5,11,-1},new int[]{16,13,-1},new int[]{6,14,-1},new int[]{5,11,-1},new int[]{1,3,-1},new int[]{8,1,-1},new int[]{1,15,-1},new int[]{16,13,-1},new int[]{16,0,-1},new int[]{6,12,-1},new int[]{5,11,-1},new int[]{8,16,-1},new int[]{18,9,-1},new int[]{1,15,-1},new int[]{18,4,-1},new int[]{4,15,-1},new int[]{0,5,-1}}            ,source,destination,target);

if(false            ){
            assertEquals(0, edges.length);
        }
        else{
                Map<Integer, Integer>[] adjs = new Map[n];
                for (int i = 0; i < n; i++) {
                    adjs[i] = new HashMap<>();
                }

                for (int[] edge : edges) {
                    adjs[edge[0]].put(edge[1], edge[2]);
                    adjs[edge[1]].put(edge[0], edge[2]);
                }

                int[] distTo = new int[n];
                Arrays.fill(distTo, Integer.MAX_VALUE);
                distTo[source] = 0;

                Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
            pq.add(new int[] { source, 0 });

            dijkstra(adjs, distTo, pq);

            assertEquals(target,distTo[destination]);
        }
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
