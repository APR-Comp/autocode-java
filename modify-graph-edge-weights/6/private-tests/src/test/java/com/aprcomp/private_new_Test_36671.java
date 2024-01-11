package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_36671        {
@Test(timeout=5000)
public void test_36671(){
int source =14    ;
int destination =19    ;
int target =1    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{1,19,396},new int[]{19,9,701},new int[]{9,17,245},new int[]{9,5,-1},new int[]{19,3,648},new int[]{19,11,402},new int[]{1,6,767},new int[]{6,13,510},new int[]{1,14,-1},new int[]{1,18,-1},new int[]{1,2,-1},new int[]{19,7,-1},new int[]{18,4,-1},new int[]{17,8,-1},new int[]{4,15,-1},new int[]{13,16,-1},new int[]{13,10,-1},new int[]{5,0,-1},new int[]{3,12,-1},new int[]{13,0,-1},new int[]{8,1,-1},new int[]{9,9,-1},new int[]{16,11,-1},new int[]{11,3,-1},new int[]{1,18,-1},new int[]{18,0,-1},new int[]{6,4,-1},new int[]{11,19,-1},new int[]{7,5,-1},new int[]{2,15,-1},new int[]{17,18,-1},new int[]{6,10,-1},new int[]{7,12,-1},new int[]{12,16,-1},new int[]{18,0,-1},new int[]{10,0,-1},new int[]{12,19,-1},new int[]{19,9,-1},new int[]{7,9,-1},new int[]{5,18,-1},new int[]{14,13,-1},new int[]{14,8,-1},new int[]{5,5,-1},new int[]{16,8,-1},new int[]{1,0,-1},new int[]{7,13,-1},new int[]{18,13,-1},new int[]{10,13,-1},new int[]{17,3,-1},new int[]{6,4,-1},new int[]{13,16,-1},new int[]{11,16,-1},new int[]{15,7,-1},new int[]{6,4,-1},new int[]{17,16,-1},new int[]{15,18,-1},new int[]{6,16,-1},new int[]{6,4,-1},new int[]{1,8,-1},new int[]{14,17,-1},new int[]{9,1,-1},new int[]{17,0,-1},new int[]{10,12,-1},new int[]{19,2,-1},new int[]{3,16,-1},new int[]{16,13,-1},new int[]{15,13,-1},new int[]{15,3,-1},new int[]{2,19,-1},new int[]{18,17,-1},new int[]{16,10,-1},new int[]{15,2,-1},new int[]{12,6,-1},new int[]{3,10,-1},new int[]{7,13,-1},new int[]{18,16,-1},new int[]{19,10,-1},new int[]{19,19,-1},new int[]{4,9,-1},new int[]{14,19,-1},new int[]{0,1,-1},new int[]{15,10,-1},new int[]{13,7,-1},new int[]{6,14,-1},new int[]{12,5,-1},new int[]{13,14,-1},new int[]{15,15,-1},new int[]{6,0,-1},new int[]{15,4,-1},new int[]{10,5,-1},new int[]{6,14,-1},new int[]{0,8,-1},new int[]{15,11,-1},new int[]{15,11,-1},new int[]{14,19,-1},new int[]{15,5,-1},new int[]{12,10,-1},new int[]{18,16,-1},new int[]{12,11,-1},new int[]{9,0,-1},new int[]{17,5,-1},new int[]{13,10,-1},new int[]{4,7,-1},new int[]{1,19,-1},new int[]{7,4,-1},new int[]{4,5,-1},new int[]{9,19,-1},new int[]{15,3,-1},new int[]{8,12,-1},new int[]{11,12,-1},new int[]{0,3,-1},new int[]{2,13,-1},new int[]{18,11,-1},new int[]{17,3,-1},new int[]{8,0,-1},new int[]{9,17,-1},new int[]{12,6,-1},new int[]{18,5,-1},new int[]{19,13,-1},new int[]{3,7,-1},new int[]{9,4,-1},new int[]{6,7,-1},new int[]{5,4,-1},new int[]{0,16,-1},new int[]{1,16,-1},new int[]{16,4,-1},new int[]{2,14,-1},new int[]{17,9,-1},new int[]{15,3,-1},new int[]{3,5,-1},new int[]{13,11,-1},new int[]{4,9,-1},new int[]{2,12,-1},new int[]{9,17,-1},new int[]{5,4,-1},new int[]{6,8,-1},new int[]{4,6,-1},new int[]{4,5,-1},new int[]{3,15,-1},new int[]{8,5,-1},new int[]{2,16,-1},new int[]{12,3,-1},new int[]{1,4,-1},new int[]{4,11,-1},new int[]{7,16,-1},new int[]{16,11,-1},new int[]{11,16,-1},new int[]{5,17,-1},new int[]{18,7,-1},new int[]{3,13,-1},new int[]{19,4,-1},new int[]{9,13,-1},new int[]{5,13,-1},new int[]{0,17,-1},new int[]{9,4,-1},new int[]{13,5,-1},new int[]{5,7,-1},new int[]{0,4,-1},new int[]{0,3,-1},new int[]{4,12,-1},new int[]{7,6,-1},new int[]{1,14,-1},new int[]{11,15,-1},new int[]{0,16,-1},new int[]{0,13,-1},new int[]{14,7,-1},new int[]{14,6,-1},new int[]{8,9,-1},new int[]{3,17,-1},new int[]{11,17,-1},new int[]{0,6,-1},new int[]{16,19,-1}}            ,source,destination,target);

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
