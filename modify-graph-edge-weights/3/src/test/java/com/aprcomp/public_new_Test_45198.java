package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
public_new_Test_45198        {
@Test(timeout=5000)
public void test_45198(){
int source =6    ;
int destination =2    ;
int target =1    ;
int n =16    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{5,7,-1},new int[]{5,8,-1},new int[]{5,6,-1},new int[]{8,0,-1},new int[]{8,14,-1},new int[]{14,13,-1},new int[]{5,15,-1},new int[]{0,1,-1},new int[]{5,11,-1},new int[]{5,12,-1},new int[]{14,3,-1},new int[]{11,10,-1},new int[]{7,9,-1},new int[]{10,4,-1},new int[]{0,2,-1},new int[]{14,8,-1},new int[]{5,13,-1},new int[]{14,4,-1},new int[]{9,1,-1},new int[]{6,12,-1},new int[]{6,1,-1},new int[]{7,2,-1},new int[]{10,13,-1},new int[]{14,9,-1},new int[]{4,11,-1},new int[]{1,11,-1},new int[]{11,15,-1},new int[]{12,4,-1},new int[]{4,12,-1},new int[]{1,12,-1},new int[]{14,0,-1},new int[]{12,12,-1},new int[]{13,7,-1},new int[]{13,13,-1},new int[]{11,7,-1},new int[]{11,4,-1},new int[]{3,12,-1},new int[]{11,1,-1},new int[]{13,11,-1},new int[]{0,9,-1},new int[]{2,11,-1},new int[]{14,1,-1},new int[]{9,12,-1},new int[]{5,12,-1},new int[]{11,4,-1},new int[]{10,13,-1},new int[]{2,11,-1},new int[]{5,12,-1},new int[]{8,13,-1},new int[]{13,11,-1},new int[]{4,4,-1},new int[]{2,3,-1},new int[]{10,15,-1},new int[]{14,5,-1},new int[]{14,12,-1},new int[]{0,4,-1},new int[]{9,8,-1},new int[]{13,2,-1},new int[]{9,10,-1},new int[]{15,5,-1},new int[]{15,6,-1},new int[]{4,0,-1},new int[]{7,6,-1},new int[]{8,13,-1},new int[]{6,2,-1},new int[]{15,6,-1},new int[]{5,1,-1},new int[]{3,15,-1},new int[]{0,0,-1},new int[]{3,14,-1},new int[]{12,0,-1},new int[]{1,15,-1},new int[]{6,10,-1},new int[]{11,5,-1},new int[]{10,2,-1},new int[]{5,3,-1}}            ,source,destination,target);

if(false            ){
            assertTrue(edges.length == 0);
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

            assertTrue(distTo[destination] == target);
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
