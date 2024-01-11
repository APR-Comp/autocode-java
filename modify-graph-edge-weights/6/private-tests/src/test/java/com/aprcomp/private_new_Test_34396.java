package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_34396        {
@Test(timeout=5000)
public void test_34396(){
int source =2    ;
int destination =0    ;
int target =95027    ;
int n =8    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{3,6,31},new int[]{6,5,31},new int[]{3,4,31},new int[]{6,7,31},new int[]{3,2,31},new int[]{4,0,31},new int[]{7,1,31},new int[]{0,2,31},new int[]{0,6,453},new int[]{6,1,-1},new int[]{2,1,-1},new int[]{0,5,-1},new int[]{2,7,-1},new int[]{2,2,-1},new int[]{1,1,252},new int[]{4,6,892},new int[]{5,2,639},new int[]{2,2,892},new int[]{3,5,404},new int[]{7,0,402},new int[]{7,2,404},new int[]{2,2,894},new int[]{3,4,404}}            ,source,destination,target);

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
