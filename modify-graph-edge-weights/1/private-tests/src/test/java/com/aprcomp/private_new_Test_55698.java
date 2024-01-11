package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_55698        {
@Test(timeout=5000)
public void test_55698(){
int source =10    ;
int destination =1    ;
int target =26    ;
int n =15    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{10,12,412},new int[]{10,8,412},new int[]{12,4,448},new int[]{10,11,412},new int[]{10,13,412},new int[]{13,5,412},new int[]{11,14,412},new int[]{12,7,412},new int[]{14,6,-1},new int[]{5,0,123},new int[]{14,2,304},new int[]{13,1,-1},new int[]{2,3,-1},new int[]{3,9,-1},new int[]{1,8,-1},new int[]{2,0,-1},new int[]{0,2,-1},new int[]{2,13,-1},new int[]{11,0,-1},new int[]{4,2,-1},new int[]{5,7,-1},new int[]{9,8,-1},new int[]{1,4,-1},new int[]{5,12,-1},new int[]{9,2,-1},new int[]{12,11,-1},new int[]{14,14,-1},new int[]{3,13,-1},new int[]{14,5,-1},new int[]{5,0,-1},new int[]{11,10,-1},new int[]{1,5,-1},new int[]{10,12,-1},new int[]{6,10,-1},new int[]{9,4,-1},new int[]{0,1,-1},new int[]{14,0,-1},new int[]{6,6,-1},new int[]{13,11,-1}}            ,source,destination,target);

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
