package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_22060        {
@Test(timeout=5000)
public void test_22060(){
int source =5    ;
int destination =6    ;
int target =80608    ;
int n =10    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{8,6,404},new int[]{6,9,254},new int[]{6,1,-1},new int[]{1,3,-1},new int[]{3,5,-1},new int[]{3,0,-1},new int[]{0,2,-1},new int[]{6,7,-1},new int[]{9,4,-1},new int[]{0,2,-1},new int[]{1,4,-1},new int[]{9,4,-1},new int[]{3,8,-1},new int[]{3,4,-1},new int[]{5,5,-1},new int[]{4,9,-1},new int[]{3,1,-1},new int[]{8,6,-1},new int[]{2,0,-1},new int[]{5,5,-1},new int[]{2,0,-1},new int[]{6,0,-1},new int[]{2,8,-1},new int[]{6,2,-1},new int[]{7,5,-1},new int[]{0,5,-1},new int[]{8,4,-1},new int[]{8,1,-1},new int[]{5,2,-1},new int[]{8,2,-1},new int[]{8,0,-1},new int[]{5,6,-1},new int[]{1,0,-1},new int[]{7,3,-1},new int[]{1,4,-1},new int[]{4,3,-1},new int[]{6,0,-1},new int[]{0,0,-1},new int[]{7,6,-1},new int[]{2,8,-1},new int[]{0,9,-1},new int[]{0,5,-1}}            ,source,destination,target);

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
