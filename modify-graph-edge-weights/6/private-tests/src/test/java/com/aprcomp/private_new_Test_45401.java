package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_45401        {
@Test(timeout=5000)
public void test_45401(){
int source =8    ;
int destination =15    ;
int target =77216    ;
int n =19    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{18,2,404},new int[]{18,8,277},new int[]{18,3,838},new int[]{3,13,639},new int[]{2,11,252},new int[]{13,0,700},new int[]{18,4,892},new int[]{0,15,14},new int[]{11,17,49},new int[]{11,7,138},new int[]{18,6,-1},new int[]{4,16,-1},new int[]{2,1,-1},new int[]{4,12,-1},new int[]{3,5,-1},new int[]{4,10,-1},new int[]{8,14,-1},new int[]{6,9,-1},new int[]{4,12,-1},new int[]{9,18,-1},new int[]{18,0,-1},new int[]{17,10,-1},new int[]{16,6,-1},new int[]{12,2,-1},new int[]{7,8,-1},new int[]{0,2,-1},new int[]{12,17,-1},new int[]{12,4,-1},new int[]{15,18,-1},new int[]{4,6,-1},new int[]{12,3,-1},new int[]{12,11,-1},new int[]{11,15,-1},new int[]{7,0,-1},new int[]{11,0,-1},new int[]{5,2,-1},new int[]{15,4,-1},new int[]{2,18,-1},new int[]{17,14,-1},new int[]{13,10,-1},new int[]{16,14,-1},new int[]{14,13,-1},new int[]{4,5,-1},new int[]{14,18,-1},new int[]{8,8,-1},new int[]{6,9,-1},new int[]{12,18,-1},new int[]{18,14,-1},new int[]{4,10,-1},new int[]{4,5,-1},new int[]{13,7,-1},new int[]{11,16,-1},new int[]{0,10,-1},new int[]{15,10,-1},new int[]{7,0,-1},new int[]{15,1,-1},new int[]{14,14,-1},new int[]{1,8,-1},new int[]{12,8,-1},new int[]{3,11,-1},new int[]{15,10,-1},new int[]{9,0,-1},new int[]{7,3,-1},new int[]{13,5,-1},new int[]{6,6,-1},new int[]{7,9,-1},new int[]{4,11,-1},new int[]{14,0,-1},new int[]{5,12,-1},new int[]{10,5,-1},new int[]{2,10,-1},new int[]{5,18,-1},new int[]{3,6,-1},new int[]{13,5,-1},new int[]{1,10,-1},new int[]{15,17,-1},new int[]{13,7,-1},new int[]{14,10,-1},new int[]{7,18,-1},new int[]{17,6,-1},new int[]{4,2,-1},new int[]{13,14,-1},new int[]{7,18,-1},new int[]{1,13,-1},new int[]{10,2,-1},new int[]{16,7,-1},new int[]{17,7,-1},new int[]{6,2,-1},new int[]{6,7,-1},new int[]{2,4,-1},new int[]{11,3,-1},new int[]{2,7,-1},new int[]{12,18,-1},new int[]{16,4,-1},new int[]{8,3,-1},new int[]{11,16,-1},new int[]{8,4,-1},new int[]{8,15,-1},new int[]{14,11,-1},new int[]{15,3,-1},new int[]{17,5,-1},new int[]{15,13,-1},new int[]{4,1,-1},new int[]{0,1,-1},new int[]{5,13,-1},new int[]{5,2,-1},new int[]{15,3,-1},new int[]{16,15,-1},new int[]{18,8,-1},new int[]{2,3,-1},new int[]{10,14,-1},new int[]{4,11,-1},new int[]{16,4,-1},new int[]{1,6,-1},new int[]{0,6,-1},new int[]{15,2,-1},new int[]{1,5,-1},new int[]{14,1,-1},new int[]{2,15,-1}}            ,source,destination,target);

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
