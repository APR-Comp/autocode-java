package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_12920        {
@Test(timeout=5000)
public void test_12920(){
int source =5    ;
int destination =8    ;
int target =24913    ;
int n =15    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{0,13,519},new int[]{0,1,519},new int[]{13,4,519},new int[]{13,12,519},new int[]{13,14,453},new int[]{0,5,519},new int[]{1,11,519},new int[]{5,10,519},new int[]{10,9,519},new int[]{11,7,519},new int[]{4,8,519},new int[]{9,6,519},new int[]{14,3,519},new int[]{1,2,519},new int[]{0,10,519},new int[]{2,10,519},new int[]{10,12,519},new int[]{9,13,519},new int[]{4,3,519},new int[]{2,4,255},new int[]{1,5,-1},new int[]{11,0,255},new int[]{4,3,-1},new int[]{11,3,255},new int[]{11,4,817},new int[]{6,3,1},new int[]{9,5,-1},new int[]{4,14,-1},new int[]{5,10,-1},new int[]{14,7,-1},new int[]{2,12,-1},new int[]{10,2,-1},new int[]{10,11,-1},new int[]{5,12,-1},new int[]{12,3,-1},new int[]{1,1,-1},new int[]{3,12,-1},new int[]{12,0,-1},new int[]{2,3,-1},new int[]{12,9,-1},new int[]{2,5,-1},new int[]{14,13,-1},new int[]{5,3,-1},new int[]{12,0,-1},new int[]{14,8,-1},new int[]{4,12,-1},new int[]{2,11,-1},new int[]{3,11,-1},new int[]{12,14,-1},new int[]{1,7,-1},new int[]{4,6,-1},new int[]{7,0,-1},new int[]{13,14,-1},new int[]{4,4,-1},new int[]{0,4,-1},new int[]{8,3,-1},new int[]{3,7,-1},new int[]{8,10,-1},new int[]{2,1,-1},new int[]{6,14,-1},new int[]{8,1,-1},new int[]{1,7,-1},new int[]{7,10,-1},new int[]{11,5,-1},new int[]{12,4,-1},new int[]{2,9,-1},new int[]{6,10,-1},new int[]{5,6,-1},new int[]{0,1,-1},new int[]{12,13,-1},new int[]{7,6,-1},new int[]{11,4,-1},new int[]{1,9,-1},new int[]{7,10,-1},new int[]{9,2,-1},new int[]{14,2,-1},new int[]{3,9,-1},new int[]{1,12,-1},new int[]{4,1,-1},new int[]{3,3,-1},new int[]{8,11,-1},new int[]{14,14,-1},new int[]{7,12,-1},new int[]{13,11,-1},new int[]{1,8,-1},new int[]{12,5,-1},new int[]{10,13,-1},new int[]{8,5,-1},new int[]{5,9,-1},new int[]{3,14,-1},new int[]{13,1,-1},new int[]{4,10,-1},new int[]{7,0,-1},new int[]{1,7,-1}}            ,source,destination,target);

if(true            ){
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
