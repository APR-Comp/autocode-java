package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_72106        {
@Test(timeout=5000)
public void test_72106(){
int source =11    ;
int destination =3    ;
int target =34744    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{1,19,730},new int[]{19,8,730},new int[]{19,18,730},new int[]{19,2,730},new int[]{19,12,730},new int[]{2,14,730},new int[]{19,4,730},new int[]{1,3,730},new int[]{3,0,730},new int[]{12,5,730},new int[]{14,10,730},new int[]{3,15,730},new int[]{14,6,730},new int[]{8,17,730},new int[]{19,11,730},new int[]{10,7,730},new int[]{2,9,730},new int[]{8,13,730},new int[]{5,16,730},new int[]{16,10,730},new int[]{1,4,730},new int[]{0,15,730},new int[]{6,17,730},new int[]{2,5,730},new int[]{16,15,730},new int[]{9,11,730},new int[]{11,9,730},new int[]{7,15,730},new int[]{19,8,730},new int[]{15,16,730},new int[]{15,9,730},new int[]{10,1,730},new int[]{15,18,730},new int[]{9,7,730},new int[]{4,13,165},new int[]{12,6,-1},new int[]{3,0,-1},new int[]{3,10,-1},new int[]{19,17,-1},new int[]{9,18,-1},new int[]{10,10,-1},new int[]{18,11,-1},new int[]{2,7,-1},new int[]{6,13,-1},new int[]{11,2,-1},new int[]{11,8,-1},new int[]{10,17,-1},new int[]{16,18,-1},new int[]{17,9,-1},new int[]{4,13,-1},new int[]{1,0,-1},new int[]{16,16,-1},new int[]{7,6,-1},new int[]{11,6,-1},new int[]{7,17,-1},new int[]{14,19,-1},new int[]{3,2,-1},new int[]{13,14,-1},new int[]{5,1,-1},new int[]{3,15,-1},new int[]{0,4,-1},new int[]{12,1,-1},new int[]{3,17,-1},new int[]{17,1,-1},new int[]{4,10,-1},new int[]{19,2,-1},new int[]{18,15,-1},new int[]{1,3,-1},new int[]{16,4,-1},new int[]{3,3,-1},new int[]{18,14,-1},new int[]{1,11,-1},new int[]{5,3,-1},new int[]{11,6,-1},new int[]{9,14,-1},new int[]{6,0,-1},new int[]{0,2,-1},new int[]{0,13,-1},new int[]{13,1,-1},new int[]{2,15,-1},new int[]{17,13,-1},new int[]{8,11,-1},new int[]{13,6,-1},new int[]{14,12,-1},new int[]{6,8,-1},new int[]{1,17,-1},new int[]{5,18,-1},new int[]{10,14,-1},new int[]{18,16,-1},new int[]{5,5,-1},new int[]{15,2,-1},new int[]{2,16,-1},new int[]{16,14,-1},new int[]{16,16,-1},new int[]{4,15,-1},new int[]{8,14,-1},new int[]{16,0,-1},new int[]{18,16,-1},new int[]{18,14,-1},new int[]{2,19,-1},new int[]{16,11,-1},new int[]{12,0,-1},new int[]{9,11,-1},new int[]{2,6,-1},new int[]{9,3,-1},new int[]{14,6,-1},new int[]{1,3,-1},new int[]{19,14,-1},new int[]{6,16,-1},new int[]{15,19,-1},new int[]{19,8,-1},new int[]{14,10,-1},new int[]{10,5,-1},new int[]{4,1,-1},new int[]{16,14,-1},new int[]{0,7,-1},new int[]{10,12,-1},new int[]{10,14,-1},new int[]{16,3,-1},new int[]{19,15,-1},new int[]{4,15,-1},new int[]{4,2,-1},new int[]{9,12,-1},new int[]{3,17,-1},new int[]{0,15,-1},new int[]{2,10,-1},new int[]{9,11,-1},new int[]{0,17,-1},new int[]{15,5,-1},new int[]{16,13,-1},new int[]{14,9,-1},new int[]{10,18,-1},new int[]{10,6,-1},new int[]{17,9,-1},new int[]{9,12,-1},new int[]{18,3,-1},new int[]{5,11,-1},new int[]{17,14,-1},new int[]{4,4,-1},new int[]{8,15,-1},new int[]{8,7,-1},new int[]{8,3,-1},new int[]{13,12,-1},new int[]{3,4,-1},new int[]{2,2,-1},new int[]{8,3,-1},new int[]{15,10,-1},new int[]{19,19,-1},new int[]{10,16,-1},new int[]{2,13,-1},new int[]{10,5,-1},new int[]{4,1,-1},new int[]{19,2,-1},new int[]{11,4,-1},new int[]{8,18,-1},new int[]{19,15,-1},new int[]{19,2,-1},new int[]{8,8,-1},new int[]{13,13,-1},new int[]{12,16,-1},new int[]{18,14,-1},new int[]{6,1,-1},new int[]{7,2,-1},new int[]{10,11,-1},new int[]{19,5,-1},new int[]{1,9,-1},new int[]{6,15,-1},new int[]{4,3,-1},new int[]{7,3,-1},new int[]{19,13,-1}}            ,source,destination,target);

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
