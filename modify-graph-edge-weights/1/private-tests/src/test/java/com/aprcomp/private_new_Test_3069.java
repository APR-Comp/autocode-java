package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_3069        {
@Test(timeout=5000)
public void test_3069(){
int source =10    ;
int destination =7    ;
int target =1    ;
int n =19    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{3,15,664},new int[]{15,18,-1},new int[]{18,16,-1},new int[]{18,4,-1},new int[]{15,8,-1},new int[]{4,13,-1},new int[]{8,6,-1},new int[]{18,10,-1},new int[]{16,5,-1},new int[]{16,11,-1},new int[]{3,0,-1},new int[]{4,1,-1},new int[]{1,9,-1},new int[]{9,7,-1},new int[]{10,17,-1},new int[]{6,12,-1},new int[]{8,14,-1},new int[]{17,2,-1},new int[]{3,5,-1},new int[]{4,8,-1},new int[]{0,17,-1},new int[]{5,10,-1},new int[]{18,8,-1},new int[]{7,9,-1},new int[]{16,16,-1},new int[]{9,10,-1},new int[]{13,15,-1},new int[]{5,11,-1},new int[]{16,10,-1},new int[]{16,6,-1},new int[]{6,9,-1},new int[]{5,7,-1},new int[]{13,15,-1},new int[]{17,10,-1},new int[]{11,17,-1},new int[]{5,15,-1},new int[]{11,16,-1},new int[]{14,14,-1},new int[]{9,11,-1},new int[]{16,8,-1},new int[]{4,13,-1},new int[]{11,7,-1},new int[]{10,5,-1},new int[]{9,18,-1},new int[]{9,14,-1},new int[]{10,0,-1},new int[]{15,4,-1},new int[]{6,10,-1},new int[]{12,1,-1},new int[]{3,13,-1},new int[]{13,15,-1},new int[]{0,4,-1},new int[]{8,15,-1},new int[]{18,15,-1},new int[]{7,2,-1},new int[]{5,5,-1},new int[]{12,18,-1},new int[]{1,1,-1},new int[]{4,14,-1},new int[]{11,3,-1},new int[]{11,7,-1},new int[]{4,16,-1},new int[]{8,12,-1},new int[]{17,10,-1},new int[]{6,14,-1},new int[]{13,0,-1},new int[]{16,1,-1},new int[]{7,16,-1},new int[]{1,8,-1},new int[]{10,8,-1},new int[]{16,7,-1},new int[]{10,7,-1},new int[]{3,1,-1},new int[]{0,5,-1},new int[]{11,0,-1},new int[]{16,7,-1},new int[]{8,4,-1},new int[]{0,10,-1},new int[]{7,2,-1},new int[]{7,14,-1},new int[]{4,7,-1},new int[]{5,15,-1},new int[]{8,8,-1},new int[]{12,10,-1},new int[]{5,5,-1},new int[]{0,8,-1},new int[]{15,18,-1},new int[]{12,5,-1},new int[]{7,1,-1},new int[]{14,16,-1},new int[]{17,7,-1},new int[]{12,17,-1},new int[]{16,8,-1},new int[]{15,18,-1},new int[]{12,16,-1},new int[]{9,9,-1},new int[]{6,18,-1},new int[]{6,8,-1},new int[]{11,14,-1},new int[]{0,15,-1},new int[]{12,15,-1},new int[]{14,6,-1},new int[]{1,12,-1},new int[]{12,13,-1},new int[]{7,15,-1},new int[]{11,6,-1},new int[]{5,13,-1},new int[]{15,15,-1},new int[]{1,3,-1},new int[]{13,14,-1},new int[]{4,9,-1},new int[]{3,8,-1},new int[]{9,9,-1},new int[]{11,9,-1},new int[]{11,2,-1},new int[]{17,10,-1},new int[]{4,0,-1},new int[]{11,11,-1},new int[]{0,8,-1},new int[]{1,4,-1},new int[]{15,14,-1},new int[]{3,5,-1},new int[]{13,5,-1},new int[]{17,5,-1},new int[]{4,0,-1},new int[]{9,5,-1},new int[]{12,3,-1},new int[]{17,6,-1}}            ,source,destination,target);

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
