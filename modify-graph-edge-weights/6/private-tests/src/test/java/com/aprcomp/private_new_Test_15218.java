package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_15218        {
@Test(timeout=5000)
public void test_15218(){
int source =3    ;
int destination =8    ;
int target =77216    ;
int n =14    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{5,10,404},new int[]{5,1,404},new int[]{10,8,404},new int[]{1,9,404},new int[]{5,6,404},new int[]{8,2,404},new int[]{10,12,404},new int[]{5,3,404},new int[]{5,7,404},new int[]{12,13,404},new int[]{1,11,404},new int[]{12,4,404},new int[]{12,0,404},new int[]{7,8,404},new int[]{9,6,404},new int[]{6,2,404},new int[]{1,5,404},new int[]{10,6,404},new int[]{7,4,404},new int[]{6,1,404},new int[]{2,3,404},new int[]{0,4,404},new int[]{12,8,404},new int[]{12,5,404},new int[]{0,7,404},new int[]{10,3,404},new int[]{2,4,404},new int[]{1,6,404},new int[]{6,13,404},new int[]{3,2,404},new int[]{8,4,404}}            ,source,destination,target);

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
