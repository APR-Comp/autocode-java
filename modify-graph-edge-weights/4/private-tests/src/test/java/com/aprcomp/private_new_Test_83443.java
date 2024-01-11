package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_83443        {
@Test(timeout=5000)
public void test_83443(){
int source =0    ;
int destination =15    ;
int target =257    ;
int n =17    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{13,14,-1},new int[]{14,0,-1},new int[]{14,11,-1},new int[]{13,4,-1},new int[]{13,12,-1},new int[]{14,6,-1},new int[]{14,15,-1},new int[]{14,8,-1},new int[]{11,2,-1},new int[]{4,10,-1},new int[]{8,9,-1},new int[]{11,1,-1},new int[]{15,5,-1},new int[]{9,3,-1},new int[]{11,16,-1},new int[]{15,7,-1},new int[]{14,13,-1},new int[]{15,14,-1},new int[]{9,10,-1},new int[]{11,14,-1},new int[]{8,10,-1},new int[]{14,8,-1},new int[]{5,9,-1},new int[]{12,2,-1},new int[]{9,4,-1},new int[]{12,2,-1},new int[]{15,12,-1},new int[]{14,15,-1},new int[]{6,1,-1},new int[]{8,13,-1},new int[]{10,12,-1},new int[]{16,11,-1},new int[]{5,14,-1},new int[]{10,13,-1},new int[]{10,13,-1},new int[]{10,5,-1},new int[]{10,16,-1},new int[]{15,6,-1},new int[]{7,15,-1},new int[]{5,6,-1},new int[]{0,6,-1},new int[]{11,14,-1},new int[]{15,12,-1},new int[]{0,3,-1},new int[]{15,12,-1},new int[]{0,5,-1},new int[]{3,14,-1},new int[]{12,1,-1},new int[]{6,10,-1},new int[]{3,1,-1},new int[]{7,5,-1},new int[]{10,5,-1},new int[]{15,11,-1},new int[]{16,2,-1},new int[]{1,12,-1},new int[]{14,9,-1},new int[]{10,9,-1},new int[]{6,2,-1},new int[]{13,16,-1},new int[]{15,13,-1},new int[]{14,14,-1},new int[]{14,8,-1},new int[]{2,8,-1},new int[]{4,6,-1},new int[]{8,11,-1},new int[]{1,14,-1},new int[]{14,16,-1},new int[]{11,16,-1},new int[]{3,1,-1},new int[]{13,10,-1},new int[]{11,9,-1},new int[]{4,0,-1},new int[]{5,1,-1},new int[]{14,1,-1},new int[]{7,15,-1},new int[]{6,7,-1},new int[]{13,14,-1},new int[]{7,14,-1},new int[]{0,11,-1},new int[]{14,0,-1},new int[]{4,3,-1},new int[]{1,13,-1},new int[]{0,5,-1},new int[]{2,5,-1},new int[]{13,5,-1},new int[]{1,15,-1},new int[]{2,0,-1},new int[]{16,9,-1},new int[]{13,15,-1},new int[]{8,1,-1},new int[]{9,0,-1},new int[]{8,10,-1},new int[]{7,12,-1},new int[]{4,16,-1},new int[]{8,6,-1},new int[]{10,5,-1},new int[]{16,9,-1},new int[]{12,10,-1},new int[]{9,13,-1},new int[]{15,3,-1},new int[]{11,16,-1},new int[]{9,7,-1},new int[]{8,0,-1},new int[]{7,1,-1},new int[]{3,9,-1},new int[]{9,5,-1},new int[]{14,6,-1},new int[]{12,1,-1},new int[]{14,1,-1},new int[]{5,15,-1},new int[]{11,9,-1},new int[]{1,5,-1},new int[]{9,7,-1},new int[]{7,4,-1},new int[]{2,7,-1},new int[]{5,2,-1},new int[]{6,8,-1},new int[]{14,8,-1},new int[]{11,11,-1},new int[]{0,1,-1},new int[]{10,12,-1},new int[]{15,7,-1},new int[]{1,8,-1},new int[]{1,1,-1},new int[]{3,0,-1},new int[]{1,2,-1}}            ,source,destination,target);

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
