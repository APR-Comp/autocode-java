package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_34559        {
@Test(timeout=5000)
public void test_34559(){
int source =0    ;
int destination =1    ;
int target =24833    ;
int n =15    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{1,14,-1},new int[]{14,3,1},new int[]{14,4,257},new int[]{14,0,24},new int[]{4,9,5},new int[]{1,6,-1},new int[]{4,11,-1},new int[]{14,12,-1},new int[]{9,5,-1},new int[]{0,7,-1},new int[]{5,10,-1},new int[]{4,8,-1},new int[]{12,13,-1},new int[]{11,2,-1},new int[]{0,7,-1},new int[]{4,3,-1},new int[]{4,7,-1},new int[]{14,7,-1},new int[]{1,12,-1},new int[]{2,13,-1},new int[]{13,0,-1},new int[]{12,4,-1},new int[]{7,6,-1},new int[]{3,3,-1},new int[]{6,3,-1},new int[]{12,14,-1},new int[]{14,12,-1},new int[]{10,8,-1},new int[]{5,4,-1},new int[]{12,9,-1},new int[]{5,3,-1},new int[]{2,9,-1},new int[]{12,7,-1},new int[]{13,12,-1},new int[]{9,4,-1},new int[]{0,11,-1},new int[]{11,0,-1},new int[]{13,3,-1},new int[]{4,0,-1},new int[]{3,5,-1},new int[]{8,11,-1},new int[]{12,5,-1},new int[]{10,0,-1},new int[]{1,7,-1},new int[]{2,1,-1},new int[]{14,14,-1},new int[]{10,12,-1},new int[]{14,6,-1},new int[]{5,13,-1},new int[]{3,7,-1},new int[]{14,8,-1},new int[]{4,11,-1},new int[]{12,4,-1},new int[]{14,13,-1},new int[]{5,7,-1},new int[]{14,13,-1},new int[]{0,1,-1},new int[]{4,0,-1},new int[]{14,8,-1}}            ,source,destination,target);

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
