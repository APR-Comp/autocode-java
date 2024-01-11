package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
public_new_Test_39815        {
@Test(timeout=5000)
public void test_39815(){
int source =0    ;
int destination =4    ;
int target =1    ;
int n =15    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{0,9,-1},new int[]{0,5,-1},new int[]{5,7,-1},new int[]{5,8,-1},new int[]{5,12,-1},new int[]{12,3,-1},new int[]{3,4,-1},new int[]{8,6,-1},new int[]{7,2,-1},new int[]{7,13,-1},new int[]{0,1,-1},new int[]{0,14,-1},new int[]{9,11,-1},new int[]{3,10,-1}}            ,source,destination,target);

if(true            ){
            assertTrue(edges.length == 0);
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

            assertTrue(distTo[destination] == target);
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
