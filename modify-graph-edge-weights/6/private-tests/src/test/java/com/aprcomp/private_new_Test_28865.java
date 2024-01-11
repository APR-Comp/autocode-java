package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_28865        {
@Test(timeout=5000)
public void test_28865(){
int source =1    ;
int destination =7    ;
int target =94102    ;
int n =15    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{14,1,249},new int[]{1,12,-1},new int[]{1,8,-1},new int[]{12,7,-1},new int[]{1,3,-1},new int[]{8,2,-1},new int[]{8,6,-1},new int[]{7,13,-1},new int[]{3,4,-1},new int[]{7,5,-1},new int[]{5,11,-1},new int[]{1,9,-1},new int[]{13,10,-1},new int[]{12,0,-1},new int[]{7,0,-1},new int[]{11,4,-1},new int[]{2,3,-1},new int[]{13,9,-1},new int[]{4,7,-1},new int[]{1,8,-1},new int[]{4,14,-1},new int[]{10,11,-1},new int[]{14,0,-1},new int[]{7,7,-1},new int[]{12,4,-1},new int[]{13,2,-1},new int[]{7,4,-1},new int[]{9,9,-1},new int[]{2,12,-1},new int[]{5,3,-1},new int[]{11,6,-1},new int[]{4,11,-1},new int[]{14,3,-1},new int[]{8,0,-1},new int[]{5,5,-1},new int[]{6,1,-1},new int[]{0,1,-1},new int[]{5,12,-1},new int[]{13,3,-1},new int[]{5,0,-1},new int[]{8,1,-1},new int[]{1,5,-1},new int[]{4,13,-1},new int[]{9,1,-1},new int[]{3,1,-1},new int[]{12,1,-1},new int[]{9,2,-1},new int[]{7,4,-1},new int[]{2,2,-1},new int[]{13,13,-1},new int[]{1,2,-1},new int[]{8,7,-1},new int[]{5,3,-1},new int[]{13,12,-1},new int[]{5,8,-1},new int[]{10,0,-1},new int[]{5,12,-1},new int[]{6,4,-1},new int[]{10,5,-1},new int[]{3,4,-1},new int[]{6,1,-1},new int[]{8,11,-1},new int[]{10,12,-1},new int[]{1,5,-1},new int[]{5,1,-1},new int[]{0,5,-1},new int[]{3,9,-1},new int[]{1,11,-1},new int[]{12,11,-1},new int[]{6,3,-1},new int[]{9,2,-1},new int[]{14,12,-1},new int[]{1,9,-1},new int[]{6,3,-1},new int[]{0,5,-1},new int[]{13,11,-1},new int[]{5,14,-1},new int[]{3,7,-1},new int[]{6,8,-1},new int[]{4,13,-1},new int[]{8,0,-1},new int[]{10,9,-1},new int[]{14,0,-1},new int[]{12,1,-1},new int[]{10,2,-1}}            ,source,destination,target);

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
