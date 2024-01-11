package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_64791        {
@Test(timeout=5000)
public void test_64791(){
int source =0    ;
int destination =16    ;
int target =133    ;
int n =19    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{16,9,-1},new int[]{16,8,-1},new int[]{8,12,-1},new int[]{9,18,-1},new int[]{8,11,-1},new int[]{18,6,-1},new int[]{6,2,-1},new int[]{18,1,-1},new int[]{6,0,-1},new int[]{1,3,-1},new int[]{6,5,-1},new int[]{16,10,-1},new int[]{8,14,-1},new int[]{9,15,-1},new int[]{12,17,-1},new int[]{3,13,-1},new int[]{0,4,-1},new int[]{4,7,-1}}            ,source,destination,target);

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
