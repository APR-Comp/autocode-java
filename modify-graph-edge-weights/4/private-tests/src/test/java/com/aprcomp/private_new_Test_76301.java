package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
private_new_Test_76301        {
@Test(timeout=5000)
public void test_76301(){
int source =15    ;
int destination =14    ;
int target =1    ;
int n =20    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{6,12,871},new int[]{12,18,717},new int[]{18,1,496},new int[]{6,4,382},new int[]{18,15,-1},new int[]{12,17,-1},new int[]{15,8,-1},new int[]{1,19,-1},new int[]{18,2,-1},new int[]{17,3,-1},new int[]{19,7,-1},new int[]{3,13,-1},new int[]{17,0,-1},new int[]{19,5,-1},new int[]{17,9,-1},new int[]{0,11,-1},new int[]{7,10,-1},new int[]{1,16,-1},new int[]{3,14,-1}}            ,source,destination,target);

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
