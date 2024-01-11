package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_27675        {
@Test(timeout=5000)
public void test_27675(){
int source =0    ;
int destination =10    ;
int target =1    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{7,19,513},new int[]{7,10,829},new int[]{19,1,606},new int[]{7,18,404},new int[]{18,9,404},new int[]{1,0,404},new int[]{18,13,254},new int[]{1,3,-1},new int[]{13,6,-1},new int[]{3,12,-1},new int[]{18,8,-1},new int[]{7,14,-1},new int[]{9,15,-1},new int[]{3,16,-1},new int[]{15,4,-1},new int[]{18,5,-1},new int[]{8,11,-1},new int[]{0,17,-1},new int[]{7,2,-1},new int[]{8,13,-1},new int[]{8,4,-1},new int[]{13,6,-1},new int[]{2,17,-1},new int[]{8,0,-1},new int[]{3,0,-1},new int[]{6,18,-1},new int[]{18,15,-1},new int[]{12,18,-1},new int[]{14,5,-1},new int[]{18,5,-1},new int[]{16,19,-1},new int[]{1,16,-1},new int[]{7,18,-1},new int[]{11,6,-1},new int[]{3,7,-1},new int[]{7,13,-1},new int[]{15,9,-1},new int[]{2,10,-1},new int[]{5,8,-1},new int[]{0,6,-1},new int[]{3,1,-1},new int[]{12,7,-1},new int[]{18,17,-1},new int[]{15,15,-1},new int[]{5,5,-1},new int[]{16,15,-1},new int[]{7,0,-1},new int[]{17,19,-1},new int[]{15,1,-1},new int[]{7,17,-1},new int[]{4,19,-1},new int[]{10,11,-1},new int[]{5,7,-1},new int[]{9,19,-1},new int[]{13,0,-1},new int[]{0,12,-1},new int[]{2,11,-1},new int[]{8,12,-1}}            ,source,destination,target);

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
