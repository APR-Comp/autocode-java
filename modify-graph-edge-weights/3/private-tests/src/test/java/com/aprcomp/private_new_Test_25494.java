package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_25494        {
@Test(timeout=5000)
public void test_25494(){
int source =12    ;
int destination =5    ;
int target =11    ;
int n =19    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{16,4,-1},new int[]{4,2,-1},new int[]{2,8,-1},new int[]{8,11,-1},new int[]{8,6,-1},new int[]{6,15,-1},new int[]{15,12,-1},new int[]{16,7,-1},new int[]{15,13,-1},new int[]{16,3,-1},new int[]{15,17,-1},new int[]{2,9,-1},new int[]{11,18,-1},new int[]{4,14,-1},new int[]{17,0,-1},new int[]{14,5,-1},new int[]{7,10,-1},new int[]{13,1,-1},new int[]{12,6,-1},new int[]{12,10,-1},new int[]{7,16,-1},new int[]{9,6,-1},new int[]{13,4,-1},new int[]{5,18,-1},new int[]{6,17,-1},new int[]{0,12,-1},new int[]{9,6,-1},new int[]{8,1,-1},new int[]{10,0,-1},new int[]{2,15,-1},new int[]{11,13,-1},new int[]{14,6,-1},new int[]{17,4,-1},new int[]{8,13,-1},new int[]{3,4,-1},new int[]{12,14,-1},new int[]{16,15,-1},new int[]{4,13,-1},new int[]{14,17,-1},new int[]{16,12,-1},new int[]{7,12,-1},new int[]{16,4,-1},new int[]{1,1,-1},new int[]{13,15,-1},new int[]{6,10,-1},new int[]{8,15,-1},new int[]{3,0,-1},new int[]{7,2,-1},new int[]{5,0,-1},new int[]{18,13,-1},new int[]{0,18,-1},new int[]{6,14,-1},new int[]{6,5,-1},new int[]{2,7,-1},new int[]{4,1,-1},new int[]{6,6,-1},new int[]{2,16,-1},new int[]{4,0,-1},new int[]{8,3,-1},new int[]{14,11,-1},new int[]{12,18,-1},new int[]{16,17,-1},new int[]{10,1,-1},new int[]{17,5,-1},new int[]{2,17,-1},new int[]{13,11,-1},new int[]{18,16,-1},new int[]{18,1,-1},new int[]{8,13,-1},new int[]{13,8,-1},new int[]{18,3,-1},new int[]{4,5,-1},new int[]{4,17,-1},new int[]{11,11,-1},new int[]{12,3,-1},new int[]{16,11,-1},new int[]{2,13,-1},new int[]{0,18,-1},new int[]{10,9,-1},new int[]{15,1,-1},new int[]{13,0,-1},new int[]{12,6,-1},new int[]{10,7,-1},new int[]{0,4,-1},new int[]{3,14,-1},new int[]{16,9,-1},new int[]{9,6,-1},new int[]{1,15,-1},new int[]{5,2,-1},new int[]{13,10,-1},new int[]{7,7,-1},new int[]{0,2,-1},new int[]{8,4,-1},new int[]{10,3,-1},new int[]{4,16,-1},new int[]{7,18,-1},new int[]{9,18,-1},new int[]{0,8,-1},new int[]{12,8,-1},new int[]{16,1,-1},new int[]{3,16,-1},new int[]{11,12,-1},new int[]{0,17,-1},new int[]{8,18,-1},new int[]{18,7,-1},new int[]{13,14,-1},new int[]{14,4,-1},new int[]{3,18,-1},new int[]{6,17,-1},new int[]{2,10,-1},new int[]{5,7,-1},new int[]{18,18,-1},new int[]{3,6,-1},new int[]{0,15,-1},new int[]{18,18,-1},new int[]{12,15,-1},new int[]{10,17,-1},new int[]{15,6,-1},new int[]{18,7,-1},new int[]{12,17,-1},new int[]{0,9,-1},new int[]{15,14,-1},new int[]{16,18,-1},new int[]{5,12,-1},new int[]{8,17,-1},new int[]{14,3,-1},new int[]{14,18,-1},new int[]{11,12,-1}}            ,source,destination,target);

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
