package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_82095        {
@Test(timeout=5000)
public void test_82095(){
int source =0    ;
int destination =12    ;
int target =1    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{1,8,356},new int[]{8,18,892},new int[]{8,14,811},new int[]{1,9,446},new int[]{14,2,404},new int[]{9,0,404},new int[]{0,16,404},new int[]{14,11,404},new int[]{1,7,410},new int[]{1,3,964},new int[]{16,12,267},new int[]{12,13,254},new int[]{11,19,287},new int[]{19,17,253},new int[]{3,6,428},new int[]{19,10,208},new int[]{13,4,84},new int[]{7,5,404},new int[]{16,15,363},new int[]{11,13,404},new int[]{3,16,187},new int[]{3,15,401},new int[]{19,13,254},new int[]{12,15,404},new int[]{16,13,404},new int[]{5,18,404},new int[]{16,15,402},new int[]{15,8,741},new int[]{3,2,973},new int[]{7,13,404},new int[]{14,11,404},new int[]{16,11,150},new int[]{15,13,-1},new int[]{15,16,-1},new int[]{18,6,-1},new int[]{2,0,-1},new int[]{14,5,-1},new int[]{3,18,-1},new int[]{7,15,-1},new int[]{4,17,-1},new int[]{18,14,-1},new int[]{4,4,-1},new int[]{1,1,-1},new int[]{8,8,-1},new int[]{13,13,-1},new int[]{5,1,-1},new int[]{3,3,-1},new int[]{15,14,-1},new int[]{13,15,-1},new int[]{8,2,-1},new int[]{14,11,-1},new int[]{7,19,-1},new int[]{12,14,-1},new int[]{18,7,-1},new int[]{11,9,-1},new int[]{6,17,-1},new int[]{2,15,-1},new int[]{0,2,-1},new int[]{3,15,-1},new int[]{1,19,-1},new int[]{16,2,-1},new int[]{4,17,-1},new int[]{0,14,-1},new int[]{7,3,-1},new int[]{6,11,-1},new int[]{2,0,-1},new int[]{5,17,-1},new int[]{11,0,-1},new int[]{0,9,-1},new int[]{18,16,-1},new int[]{0,3,-1},new int[]{17,19,-1},new int[]{8,18,-1},new int[]{1,7,-1},new int[]{11,8,-1},new int[]{8,16,-1},new int[]{0,14,-1},new int[]{12,4,-1},new int[]{13,9,-1},new int[]{17,2,-1},new int[]{12,9,-1},new int[]{4,5,-1},new int[]{12,8,-1},new int[]{6,15,-1},new int[]{1,11,-1},new int[]{3,10,-1},new int[]{13,17,-1},new int[]{19,2,-1},new int[]{15,0,-1},new int[]{17,2,-1},new int[]{0,19,-1},new int[]{14,13,-1},new int[]{12,18,-1},new int[]{17,2,-1},new int[]{15,13,-1},new int[]{19,13,-1},new int[]{17,8,-1},new int[]{1,11,-1},new int[]{12,1,-1},new int[]{0,7,-1},new int[]{1,16,-1},new int[]{17,13,-1},new int[]{7,13,-1},new int[]{8,1,-1},new int[]{0,0,-1},new int[]{5,7,-1},new int[]{1,19,-1},new int[]{6,10,-1},new int[]{11,3,-1},new int[]{9,16,-1},new int[]{6,9,-1},new int[]{6,6,-1},new int[]{5,7,-1},new int[]{19,11,-1},new int[]{8,4,-1},new int[]{11,10,-1},new int[]{15,18,-1},new int[]{5,9,-1},new int[]{8,12,-1},new int[]{17,11,-1},new int[]{4,15,-1}}            ,source,destination,target);

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
