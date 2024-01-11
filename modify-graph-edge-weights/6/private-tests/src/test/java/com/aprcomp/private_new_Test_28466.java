package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_28466        {
@Test(timeout=5000)
public void test_28466(){
int source =8    ;
int destination =5    ;
int target =77216    ;
int n =19    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{12,13,404},new int[]{12,11,254},new int[]{11,9,-1},new int[]{9,6,-1},new int[]{6,15,-1},new int[]{15,14,-1},new int[]{15,17,-1},new int[]{14,8,-1},new int[]{11,1,-1},new int[]{1,7,-1},new int[]{6,2,-1},new int[]{1,0,-1},new int[]{17,3,-1},new int[]{15,16,-1},new int[]{0,18,-1},new int[]{15,5,-1},new int[]{5,10,-1},new int[]{5,4,-1},new int[]{7,8,-1},new int[]{9,9,-1},new int[]{2,15,-1},new int[]{11,5,-1},new int[]{3,8,-1},new int[]{3,6,-1},new int[]{12,12,-1},new int[]{4,15,-1},new int[]{11,6,-1},new int[]{16,3,-1},new int[]{16,14,-1},new int[]{5,0,-1},new int[]{10,13,-1},new int[]{12,6,-1},new int[]{5,17,-1},new int[]{14,17,-1},new int[]{1,9,-1},new int[]{5,11,-1},new int[]{7,1,-1},new int[]{8,5,-1},new int[]{5,16,-1},new int[]{2,4,-1},new int[]{2,7,-1},new int[]{0,18,-1},new int[]{10,6,-1},new int[]{11,14,-1},new int[]{10,17,-1},new int[]{4,14,-1},new int[]{8,15,-1},new int[]{7,14,-1},new int[]{3,4,-1},new int[]{11,7,-1},new int[]{16,5,-1},new int[]{9,9,-1},new int[]{3,7,-1},new int[]{10,16,-1},new int[]{8,4,-1},new int[]{18,13,-1},new int[]{10,0,-1},new int[]{7,11,-1},new int[]{10,5,-1},new int[]{15,17,-1},new int[]{14,9,-1},new int[]{13,7,-1},new int[]{10,1,-1},new int[]{5,1,-1},new int[]{11,11,-1},new int[]{11,6,-1},new int[]{15,4,-1},new int[]{0,0,-1},new int[]{4,12,-1},new int[]{13,10,-1},new int[]{10,12,-1},new int[]{0,16,-1},new int[]{4,18,-1},new int[]{8,5,-1},new int[]{9,7,-1},new int[]{2,3,-1},new int[]{11,11,-1},new int[]{1,7,-1},new int[]{8,14,-1},new int[]{8,10,-1},new int[]{1,5,-1},new int[]{0,9,-1},new int[]{2,9,-1},new int[]{11,5,-1},new int[]{4,7,-1},new int[]{10,11,-1},new int[]{16,9,-1},new int[]{13,16,-1},new int[]{6,15,-1},new int[]{13,6,-1},new int[]{5,16,-1},new int[]{17,5,-1},new int[]{10,7,-1},new int[]{7,0,-1},new int[]{6,3,-1},new int[]{14,9,-1},new int[]{13,14,-1},new int[]{0,17,-1},new int[]{5,18,-1},new int[]{1,10,-1},new int[]{0,8,-1},new int[]{0,3,-1},new int[]{10,14,-1},new int[]{2,12,-1},new int[]{8,3,-1},new int[]{0,8,-1},new int[]{15,4,-1},new int[]{18,12,-1},new int[]{13,11,-1},new int[]{6,15,-1},new int[]{2,0,-1},new int[]{13,5,-1},new int[]{15,18,-1},new int[]{8,17,-1},new int[]{10,1,-1},new int[]{6,17,-1},new int[]{12,15,-1},new int[]{2,2,-1},new int[]{14,12,-1}}            ,source,destination,target);

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
