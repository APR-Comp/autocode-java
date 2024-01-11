package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class
public_new_Test_28403        {
@Test(timeout=5000)
public void test_28403(){
int source =0    ;
int destination =13    ;
int target =20756993    ;
int n =15    ;
int[][] edges = new Solution().modifiedGraphEdges(n,new int[][]{new int[]{1,0,2047},new int[]{1,12,9471},new int[]{1,3,-1},new int[]{3,6,128767},new int[]{6,11,-1},new int[]{6,2,65538},new int[]{12,10,-1},new int[]{1,5,65535},new int[]{11,8,524287},new int[]{12,13,65535},new int[]{0,4,449503},new int[]{11,14,131070},new int[]{12,7,727775},new int[]{12,9,255},new int[]{9,10,2047},new int[]{2,9,-1},new int[]{0,10,194295},new int[]{5,4,65535},new int[]{0,11,524287},new int[]{8,2,65535},new int[]{7,2,-1},new int[]{14,7,-1},new int[]{12,11,129022},new int[]{9,7,65535},new int[]{0,2,885627},new int[]{0,3,255},new int[]{7,6,-1},new int[]{6,7,437165},new int[]{4,2,69},new int[]{6,3,612909},new int[]{10,10,654005},new int[]{0,13,255},new int[]{11,1,-1},new int[]{11,14,255},new int[]{5,0,-1},new int[]{13,11,524287},new int[]{9,13,255},new int[]{0,12,-1},new int[]{3,2,-1},new int[]{8,12,16},new int[]{12,3,255},new int[]{14,4,196607},new int[]{10,14,255},new int[]{9,9,2047},new int[]{11,10,255},new int[]{5,14,64255},new int[]{10,8,510},new int[]{14,10,776990},new int[]{8,3,9},new int[]{5,8,-1},new int[]{2,10,16383},new int[]{14,11,255},new int[]{9,6,2047},new int[]{1,4,255},new int[]{10,10,-1},new int[]{13,0,-1},new int[]{9,9,502},new int[]{5,0,711903},new int[]{7,13,11271},new int[]{9,14,1},new int[]{7,10,36863},new int[]{8,8,-1},new int[]{8,1,636780},new int[]{7,11,609597},new int[]{6,3,1},new int[]{13,11,1},new int[]{1,11,2047},new int[]{7,8,1},new int[]{8,5,-1},new int[]{2,3,-1},new int[]{0,8,114173},new int[]{14,2,9},new int[]{11,2,1},new int[]{5,9,255},new int[]{6,7,-1},new int[]{3,7,-1},new int[]{3,7,2}}            ,source,destination,target);

if(true            ){
            assertTrue(edges.length == 0);
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

            assertTrue(distTo[destination] == target);
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
