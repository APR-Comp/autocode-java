package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_15936        {
@Test(timeout=5000)
public void test_15936(){
int source =15    ;
int destination =14    ;
int target =77216    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{11,5,289},new int[]{5,7,909},new int[]{11,0,909},new int[]{0,6,909},new int[]{7,18,909},new int[]{5,15,909},new int[]{0,14,909},new int[]{14,19,909},new int[]{14,13,909},new int[]{19,1,909},new int[]{1,17,909},new int[]{14,16,909},new int[]{6,9,909},new int[]{13,3,909},new int[]{11,12,909},new int[]{15,4,909},new int[]{3,2,22},new int[]{9,8,404},new int[]{3,10,254},new int[]{16,8,-1},new int[]{4,1,-1},new int[]{8,11,-1},new int[]{15,3,-1},new int[]{15,1,-1},new int[]{6,14,-1},new int[]{12,11,-1},new int[]{8,10,-1},new int[]{9,4,-1},new int[]{0,14,-1},new int[]{18,5,-1},new int[]{6,4,-1},new int[]{11,18,-1},new int[]{4,10,-1},new int[]{9,16,-1},new int[]{2,5,-1},new int[]{1,13,-1},new int[]{4,10,-1},new int[]{16,2,-1},new int[]{12,3,-1},new int[]{0,17,-1},new int[]{9,8,-1},new int[]{2,14,-1},new int[]{12,13,-1},new int[]{13,4,-1},new int[]{0,17,-1},new int[]{10,19,-1},new int[]{2,5,-1},new int[]{14,1,-1},new int[]{2,0,-1},new int[]{12,0,-1},new int[]{15,19,-1},new int[]{19,3,-1},new int[]{4,15,-1},new int[]{0,14,-1},new int[]{7,7,-1},new int[]{16,14,-1},new int[]{3,13,-1},new int[]{11,0,-1},new int[]{15,19,-1},new int[]{18,0,-1},new int[]{5,3,-1},new int[]{0,15,-1},new int[]{1,5,-1},new int[]{19,14,-1},new int[]{13,5,-1},new int[]{14,7,-1},new int[]{14,9,-1},new int[]{2,4,-1},new int[]{13,17,-1},new int[]{5,3,-1},new int[]{8,3,-1},new int[]{8,15,-1},new int[]{8,8,-1},new int[]{6,18,-1},new int[]{15,13,-1},new int[]{17,18,-1},new int[]{13,13,-1},new int[]{19,18,-1},new int[]{3,10,-1},new int[]{17,16,-1},new int[]{18,0,-1},new int[]{17,0,-1},new int[]{16,1,-1},new int[]{9,19,-1},new int[]{1,2,-1},new int[]{14,19,-1},new int[]{12,12,-1},new int[]{0,4,-1},new int[]{14,12,-1},new int[]{2,14,-1},new int[]{13,10,-1},new int[]{14,17,-1},new int[]{16,18,-1},new int[]{4,17,-1},new int[]{2,19,-1},new int[]{6,10,-1},new int[]{4,14,-1},new int[]{9,19,-1},new int[]{7,3,-1},new int[]{9,8,-1},new int[]{11,3,-1},new int[]{4,3,-1}}            ,source,destination,target);

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
