package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_12631        {
@Test(timeout=5000)
public void test_12631(){
int source =0    ;
int destination =4    ;
int target =77216    ;
int n =15    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{8,9,404},new int[]{8,14,404},new int[]{14,11,404},new int[]{8,7,404},new int[]{8,3,404},new int[]{11,5,404},new int[]{14,4,404},new int[]{3,13,404},new int[]{13,1,404},new int[]{5,0,404},new int[]{0,10,404},new int[]{14,6,404},new int[]{14,12,404},new int[]{7,2,404},new int[]{13,13,404},new int[]{1,14,404},new int[]{0,4,404},new int[]{9,7,404},new int[]{0,3,404},new int[]{2,2,404},new int[]{10,1,404},new int[]{14,2,404},new int[]{5,8,404},new int[]{12,13,404},new int[]{4,10,404},new int[]{5,14,404},new int[]{4,4,404},new int[]{7,13,404},new int[]{14,11,404},new int[]{6,2,404},new int[]{14,13,404},new int[]{7,4,404},new int[]{9,2,404},new int[]{13,0,404},new int[]{12,0,404},new int[]{10,6,404},new int[]{8,14,404},new int[]{3,12,404},new int[]{8,3,404},new int[]{13,2,404},new int[]{2,10,404},new int[]{6,8,404},new int[]{11,14,404},new int[]{9,14,404},new int[]{2,5,404},new int[]{13,6,404},new int[]{5,14,73},new int[]{7,13,404},new int[]{6,1,404},new int[]{8,14,404},new int[]{7,0,404},new int[]{2,0,404},new int[]{13,14,404},new int[]{9,5,404},new int[]{9,6,117},new int[]{4,2,-1},new int[]{14,4,-1},new int[]{7,11,-1},new int[]{14,11,-1},new int[]{7,7,-1},new int[]{14,6,-1},new int[]{7,0,-1},new int[]{10,5,-1},new int[]{6,9,-1},new int[]{2,4,-1},new int[]{7,11,-1},new int[]{8,1,-1},new int[]{11,0,-1},new int[]{11,1,-1},new int[]{2,3,-1},new int[]{12,0,-1},new int[]{0,11,-1},new int[]{13,7,-1},new int[]{12,2,-1},new int[]{1,3,-1},new int[]{6,8,-1},new int[]{14,1,-1},new int[]{2,1,-1},new int[]{6,14,-1},new int[]{6,12,-1},new int[]{9,13,-1},new int[]{0,6,-1},new int[]{0,5,-1},new int[]{9,4,-1},new int[]{2,8,-1}}            ,source,destination,target);

if(true            ){
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
