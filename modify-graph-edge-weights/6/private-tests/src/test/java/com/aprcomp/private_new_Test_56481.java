package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_56481        {
@Test(timeout=5000)
public void test_56481(){
int source =0    ;
int destination =10    ;
int target =77216    ;
int n =15    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{3,7,404},new int[]{3,14,254},new int[]{3,12,-1},new int[]{7,2,-1},new int[]{7,0,-1},new int[]{0,8,-1},new int[]{3,9,-1},new int[]{9,10,-1},new int[]{12,11,-1},new int[]{14,4,-1},new int[]{10,13,-1},new int[]{11,5,-1},new int[]{10,1,-1},new int[]{10,6,-1},new int[]{2,7,-1},new int[]{11,1,-1},new int[]{12,5,-1},new int[]{3,13,-1},new int[]{10,2,-1},new int[]{3,3,-1},new int[]{12,3,-1},new int[]{5,10,-1},new int[]{14,5,-1},new int[]{9,3,-1},new int[]{13,12,-1},new int[]{14,10,-1},new int[]{8,10,-1},new int[]{10,4,-1},new int[]{6,10,-1},new int[]{6,7,-1},new int[]{14,7,-1},new int[]{10,4,-1},new int[]{3,13,-1},new int[]{8,10,-1},new int[]{10,11,-1},new int[]{2,0,-1},new int[]{0,4,-1},new int[]{1,11,-1},new int[]{2,4,-1},new int[]{14,13,-1},new int[]{14,13,-1},new int[]{7,7,-1},new int[]{4,1,-1},new int[]{6,14,-1},new int[]{10,5,-1},new int[]{12,0,-1},new int[]{6,11,-1},new int[]{14,14,-1},new int[]{5,3,-1},new int[]{8,8,-1},new int[]{9,7,-1},new int[]{5,3,-1},new int[]{5,10,-1},new int[]{7,8,-1},new int[]{8,4,-1},new int[]{8,7,-1},new int[]{7,1,-1},new int[]{13,4,-1},new int[]{13,5,-1},new int[]{7,11,-1},new int[]{3,12,-1},new int[]{12,7,-1},new int[]{5,13,-1},new int[]{7,5,-1},new int[]{10,14,-1},new int[]{10,9,-1},new int[]{7,14,-1},new int[]{4,8,-1},new int[]{7,3,-1},new int[]{10,12,-1},new int[]{1,2,-1}}            ,source,destination,target);

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
