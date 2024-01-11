package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_10332        {
@Test(timeout=5000)
public void test_10332(){
int source =0    ;
int destination =18    ;
int target =1    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{9,18,356},new int[]{18,13,892},new int[]{9,19,811},new int[]{19,4,446},new int[]{19,15,404},new int[]{4,6,404},new int[]{13,14,404},new int[]{18,12,404},new int[]{19,8,410},new int[]{15,3,964},new int[]{8,17,267},new int[]{4,16,686},new int[]{13,7,117},new int[]{16,5,925},new int[]{19,10,262},new int[]{18,0,80},new int[]{16,1,512},new int[]{1,2,404},new int[]{2,11,404},new int[]{7,6,149},new int[]{0,7,404},new int[]{10,16,404},new int[]{17,4,404},new int[]{11,9,187},new int[]{16,9,401},new int[]{9,10,254},new int[]{14,11,404},new int[]{3,7,404},new int[]{8,1,404},new int[]{3,11,402},new int[]{13,6,741},new int[]{12,0,973},new int[]{18,13,404},new int[]{2,6,404},new int[]{19,17,150},new int[]{5,12,-1},new int[]{11,1,-1},new int[]{17,7,-1},new int[]{17,2,-1},new int[]{18,0,-1},new int[]{16,1,-1},new int[]{19,14,-1},new int[]{19,4,-1},new int[]{10,17,-1},new int[]{18,14,-1},new int[]{8,13,-1},new int[]{18,3,-1},new int[]{9,0,-1},new int[]{18,6,-1},new int[]{6,0,-1},new int[]{19,14,-1},new int[]{14,19,-1},new int[]{1,5,-1},new int[]{3,17,-1},new int[]{15,18,-1},new int[]{4,5,-1},new int[]{17,2,-1},new int[]{3,18,-1},new int[]{1,1,-1},new int[]{15,12,-1},new int[]{13,18,-1},new int[]{8,4,-1},new int[]{6,13,-1},new int[]{19,0,-1},new int[]{13,4,-1},new int[]{18,11,-1},new int[]{11,7,-1},new int[]{16,3,-1},new int[]{3,8,-1},new int[]{4,3,-1},new int[]{19,11,-1},new int[]{15,16,-1},new int[]{11,8,-1},new int[]{8,7,-1},new int[]{1,18,-1},new int[]{6,5,-1},new int[]{11,3,-1},new int[]{2,7,-1},new int[]{19,6,-1},new int[]{5,14,-1},new int[]{16,8,-1},new int[]{8,15,-1},new int[]{4,16,-1},new int[]{5,7,-1},new int[]{8,18,-1},new int[]{8,18,-1},new int[]{14,13,-1},new int[]{14,12,-1},new int[]{13,6,-1},new int[]{11,13,-1},new int[]{14,14,-1},new int[]{5,10,-1},new int[]{15,13,-1},new int[]{14,0,-1},new int[]{11,2,-1},new int[]{12,15,-1},new int[]{8,10,-1},new int[]{17,6,-1},new int[]{9,4,-1},new int[]{9,18,-1},new int[]{11,14,-1},new int[]{0,3,-1},new int[]{0,9,-1},new int[]{3,1,-1},new int[]{12,13,-1},new int[]{5,7,-1},new int[]{17,8,-1},new int[]{4,11,-1},new int[]{0,14,-1},new int[]{5,2,-1},new int[]{5,5,-1},new int[]{13,3,-1},new int[]{19,6,-1},new int[]{17,12,-1},new int[]{1,0,-1},new int[]{10,7,-1},new int[]{10,6,-1},new int[]{19,11,-1},new int[]{2,0,-1},new int[]{14,16,-1},new int[]{19,0,-1}}            ,source,destination,target);

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
