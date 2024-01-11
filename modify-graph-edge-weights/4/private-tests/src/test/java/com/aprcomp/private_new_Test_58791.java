package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_58791        {
@Test(timeout=5000)
public void test_58791(){
int source =0    ;
int destination =7    ;
int target =1    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{19,14,169},new int[]{19,0,892},new int[]{0,1,892},new int[]{0,2,169},new int[]{19,5,892},new int[]{19,11,892},new int[]{2,6,198},new int[]{11,17,404},new int[]{2,9,404},new int[]{0,15,404},new int[]{6,18,404},new int[]{2,16,404},new int[]{18,7,404},new int[]{15,3,404},new int[]{1,10,404},new int[]{0,12,404},new int[]{5,8,512},new int[]{2,13,404},new int[]{7,4,404},new int[]{13,18,149},new int[]{7,4,404},new int[]{17,6,404},new int[]{4,8,404},new int[]{16,7,187},new int[]{7,2,187},new int[]{10,2,404},new int[]{6,2,80},new int[]{9,13,404},new int[]{1,1,404},new int[]{5,7,404},new int[]{16,10,404},new int[]{9,3,404},new int[]{12,4,404},new int[]{8,19,404},new int[]{0,11,404},new int[]{7,10,404},new int[]{18,18,404},new int[]{18,10,404},new int[]{12,7,404},new int[]{12,5,404},new int[]{0,6,404},new int[]{1,2,404},new int[]{15,14,404},new int[]{10,16,404},new int[]{12,4,404},new int[]{7,2,295},new int[]{14,13,447},new int[]{5,4,447},new int[]{16,12,447},new int[]{1,18,447},new int[]{3,18,447},new int[]{4,8,447},new int[]{12,16,447},new int[]{11,19,447},new int[]{0,10,447},new int[]{16,17,447},new int[]{1,19,447},new int[]{15,4,447},new int[]{2,16,447},new int[]{11,19,447},new int[]{4,12,447},new int[]{1,19,447},new int[]{17,12,447},new int[]{6,13,447},new int[]{4,12,447},new int[]{13,15,447},new int[]{5,15,447},new int[]{16,18,447},new int[]{3,10,447},new int[]{2,1,447},new int[]{2,1,447},new int[]{12,12,556},new int[]{5,19,404},new int[]{1,12,404},new int[]{11,6,404},new int[]{14,14,533},new int[]{19,6,-1},new int[]{9,4,-1},new int[]{15,3,536},new int[]{15,19,404},new int[]{9,13,404},new int[]{2,18,404},new int[]{16,9,404},new int[]{1,19,404},new int[]{1,0,404},new int[]{5,4,404},new int[]{13,14,404},new int[]{2,16,240},new int[]{12,5,404},new int[]{6,16,404},new int[]{4,12,172},new int[]{15,4,694},new int[]{18,10,496},new int[]{15,15,404},new int[]{13,5,404},new int[]{1,18,404},new int[]{11,6,404},new int[]{17,17,156},new int[]{10,11,404},new int[]{14,19,404},new int[]{5,17,404},new int[]{9,3,404},new int[]{7,17,404},new int[]{1,12,404},new int[]{2,13,404},new int[]{17,1,404},new int[]{8,17,-1},new int[]{10,0,254},new int[]{12,5,404},new int[]{4,7,404},new int[]{8,6,404},new int[]{0,7,404},new int[]{3,15,404},new int[]{6,8,404},new int[]{7,18,404},new int[]{3,1,404},new int[]{3,15,228},new int[]{9,8,404},new int[]{7,3,149},new int[]{6,2,103},new int[]{5,2,428},new int[]{9,16,208},new int[]{16,19,84},new int[]{9,15,7},new int[]{18,12,404},new int[]{13,18,404},new int[]{11,14,404},new int[]{1,2,404},new int[]{15,10,404},new int[]{10,1,404},new int[]{15,14,404},new int[]{3,11,404},new int[]{17,10,404},new int[]{12,6,404},new int[]{7,11,404},new int[]{0,2,404}}            ,source,destination,target);

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
