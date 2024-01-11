package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_54401        {
@Test(timeout=5000)
public void test_54401(){
int source =0    ;
int destination =11    ;
int target =1    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{11,5,356},new int[]{5,1,892},new int[]{5,2,811},new int[]{5,9,446},new int[]{11,13,404},new int[]{11,19,453},new int[]{11,8,-1},new int[]{1,15,101},new int[]{15,4,356},new int[]{4,18,892},new int[]{11,6,811},new int[]{1,12,446},new int[]{1,16,404},new int[]{5,10,404},new int[]{13,3,404},new int[]{5,17,404},new int[]{11,14,410},new int[]{13,7,964},new int[]{3,0,267},new int[]{10,14,404},new int[]{7,8,80},new int[]{3,2,404},new int[]{19,12,404},new int[]{7,0,208},new int[]{11,11,402},new int[]{15,17,709},new int[]{5,4,973},new int[]{17,0,404},new int[]{18,2,404},new int[]{19,9,404},new int[]{1,16,404},new int[]{0,8,295},new int[]{8,7,887},new int[]{1,14,404},new int[]{18,18,402},new int[]{10,4,254},new int[]{12,6,404},new int[]{15,6,404},new int[]{11,1,404},new int[]{15,15,328},new int[]{7,10,892},new int[]{2,16,145},new int[]{14,19,254},new int[]{1,10,404},new int[]{19,9,404},new int[]{11,15,1},new int[]{3,10,-1},new int[]{0,0,-1},new int[]{3,7,-1},new int[]{4,18,-1},new int[]{3,2,-1},new int[]{16,12,-1},new int[]{13,1,-1},new int[]{6,2,-1},new int[]{17,3,-1},new int[]{10,13,-1},new int[]{16,17,-1},new int[]{5,3,-1},new int[]{5,11,-1},new int[]{2,3,-1},new int[]{14,18,-1},new int[]{15,19,-1},new int[]{8,4,-1},new int[]{12,7,-1},new int[]{18,9,-1},new int[]{0,1,-1},new int[]{16,0,-1},new int[]{6,9,-1},new int[]{16,5,-1},new int[]{8,15,-1},new int[]{19,13,-1},new int[]{17,8,-1},new int[]{15,6,-1},new int[]{18,8,-1},new int[]{8,15,-1},new int[]{9,19,-1},new int[]{12,19,-1},new int[]{4,3,-1},new int[]{8,10,-1},new int[]{9,17,-1},new int[]{6,14,-1},new int[]{2,19,-1},new int[]{16,7,-1},new int[]{11,11,-1},new int[]{13,7,-1},new int[]{5,7,-1},new int[]{16,1,-1},new int[]{7,10,-1},new int[]{12,18,-1},new int[]{13,17,-1},new int[]{12,6,-1},new int[]{7,9,-1},new int[]{5,8,-1},new int[]{4,18,-1},new int[]{8,4,-1},new int[]{10,5,-1},new int[]{7,2,-1},new int[]{6,1,-1},new int[]{16,17,-1},new int[]{15,2,-1},new int[]{17,6,-1},new int[]{12,17,-1},new int[]{3,8,-1},new int[]{12,10,-1},new int[]{11,14,-1},new int[]{6,0,-1},new int[]{9,17,-1},new int[]{10,6,-1},new int[]{12,16,-1},new int[]{5,15,-1},new int[]{6,5,-1},new int[]{4,19,-1},new int[]{17,11,-1},new int[]{17,13,-1},new int[]{19,15,-1},new int[]{17,3,-1},new int[]{10,8,-1},new int[]{5,3,-1},new int[]{19,11,-1},new int[]{2,15,-1},new int[]{5,13,-1}}            ,source,destination,target);

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
