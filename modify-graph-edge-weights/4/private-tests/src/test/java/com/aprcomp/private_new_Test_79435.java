package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_79435        {
@Test(timeout=5000)
public void test_79435(){
int source =14    ;
int destination =1    ;
int target =45232    ;
int n =16    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{13,7,84},new int[]{7,2,63},new int[]{13,1,-1},new int[]{1,9,-1},new int[]{1,5,-1},new int[]{7,10,-1},new int[]{5,15,-1},new int[]{7,11,-1},new int[]{13,0,-1},new int[]{0,14,-1},new int[]{2,3,-1},new int[]{3,6,-1},new int[]{5,4,-1},new int[]{14,12,-1},new int[]{9,8,-1},new int[]{4,7,-1},new int[]{9,5,-1},new int[]{6,0,-1},new int[]{12,2,-1},new int[]{12,5,-1},new int[]{14,1,-1},new int[]{14,4,-1},new int[]{5,3,-1},new int[]{6,15,-1},new int[]{5,6,-1},new int[]{14,15,-1},new int[]{14,12,-1},new int[]{5,11,-1},new int[]{9,12,-1},new int[]{9,11,-1},new int[]{5,12,-1},new int[]{0,14,-1},new int[]{12,7,-1},new int[]{0,14,-1},new int[]{10,3,-1},new int[]{7,15,-1},new int[]{6,10,-1},new int[]{12,12,-1},new int[]{4,1,-1},new int[]{5,14,-1},new int[]{9,10,-1},new int[]{9,4,-1},new int[]{3,7,-1},new int[]{4,0,-1},new int[]{0,0,-1},new int[]{3,12,-1},new int[]{4,11,-1},new int[]{4,7,-1},new int[]{3,9,-1},new int[]{11,2,-1},new int[]{5,4,-1},new int[]{11,6,-1},new int[]{12,1,-1},new int[]{6,12,-1},new int[]{5,6,-1},new int[]{4,9,-1},new int[]{5,9,-1},new int[]{7,1,-1},new int[]{11,2,-1},new int[]{8,3,-1},new int[]{10,15,-1},new int[]{13,10,-1},new int[]{8,14,-1},new int[]{9,9,-1},new int[]{14,14,-1},new int[]{3,2,-1},new int[]{0,12,-1},new int[]{6,15,-1},new int[]{14,14,-1},new int[]{3,12,-1},new int[]{12,6,-1},new int[]{10,3,-1},new int[]{7,14,-1},new int[]{4,8,-1},new int[]{5,10,-1},new int[]{7,14,-1},new int[]{2,1,-1},new int[]{5,15,-1},new int[]{11,11,-1},new int[]{11,8,-1},new int[]{5,11,-1},new int[]{6,13,-1},new int[]{13,6,-1},new int[]{1,14,-1},new int[]{12,15,-1},new int[]{14,14,-1},new int[]{0,0,-1},new int[]{2,2,-1},new int[]{1,11,-1},new int[]{4,10,-1},new int[]{11,15,-1},new int[]{2,6,-1},new int[]{7,0,-1},new int[]{9,2,-1},new int[]{12,9,-1},new int[]{10,0,-1},new int[]{6,12,-1},new int[]{14,4,-1},new int[]{7,13,-1},new int[]{14,3,-1},new int[]{12,1,-1},new int[]{8,0,-1},new int[]{12,13,-1},new int[]{6,0,-1},new int[]{3,2,-1},new int[]{7,15,-1},new int[]{10,12,-1},new int[]{14,9,-1},new int[]{8,3,-1},new int[]{15,13,-1},new int[]{3,3,-1},new int[]{1,8,-1},new int[]{12,5,-1},new int[]{6,3,-1},new int[]{6,13,-1},new int[]{2,8,-1},new int[]{9,4,-1},new int[]{6,1,-1},new int[]{4,6,-1},new int[]{14,13,-1}}            ,source,destination,target);

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
