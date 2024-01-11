package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import com.code_intelligence.jazzer.third_party.kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;

public class SimpleFuzzTest {
    static int co = 0;

    String convert(int[][] x) {
        StringBuilder y = new StringBuilder();
        y.append("new int[][]{");
        for (int i = 0; i < x.length; i++) {
            if(i != 0){
                y.append(',');
            }
            y.append("new int[]{");
            for (int j = 0; j < x[i].length; j++) {
                if (j != 0) {
                    y.append(',');
                }
                y.append(x[i][j]);
            }

            y.append("}");
        }
        y.append("}");
        return y.toString();
    }

    Random rng = new Random();

    @FuzzTest(maxDuration = "10s")
    void fuzzSolution(FuzzedDataProvider data) {
        int n = data.consumeInt(2, 20);
        int target = data.consumeInt(1, 100000);
        int source = data.consumeInt(0, n - 1);
        int destination = rng.nextInt(n);
        while (destination == source) {
            destination = rng.nextInt(n);
        }

        int edgeCount = data.consumeInt(n-1, (n * (n - 1)) / 2);
        int[][] edges = new int[edgeCount][3];
        int[][] edgesOrig = new int[edgeCount][3];

        List<Integer> connection = new ArrayList<>();
        List<Integer> unconnected = IntStream.range(0, n).mapToObj(x -> x).collect(Collectors.toList());

        int index = rng.nextInt(unconnected.size());
        connection.add(unconnected.remove(index));

        for (int i = 0; i < edgeCount; i++) {
            int c = data.consumeInt(-1, 1000);
            if (c == 0) {
                c = data.consumeInt(1, 1000);
            }
            int a = connection.get(rng.nextInt(connection.size()));
            int b = 0;
            if (unconnected.size() != 0) {
                index = rng.nextInt(unconnected.size());
                b = unconnected.get(index);
                unconnected.remove(index);
                connection.add(b);
            } else {
                b = connection.get(rng.nextInt(connection.size()));
            }
            edges[i] = new int[] { a, b, c };
            edgesOrig[i] = new int[] { a, b, c };

        }

        co++;
        int[][] x = new Solution().modifiedGraphEdges(n, edges, source, destination, target);

        String pattern = "false";
        if(x.length == 0){
            pattern = "true";
        }

        String className = String.format("%s_new_Test_%d",System.getenv("TEST_TYPE"),co); 
        
        String template = """
package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class 
 """
        + className +
        """ 
            {
    @Test(timeout=5000)
    public void test_"""+ co + """
        (){
        int source = """+ source + """
            ;
        int destination = """+ destination + """
            ;
        int target = """ + target + """
            ;
        int n = """+ n + """
            ;
        int[][] edges = new Solution().modifiedGraphEdges(n,"""
        + convert(edgesOrig) +
                """
                    ,source,destination,target);
    
        if("""+ pattern + """
            ){
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
""";


        String body = String.format(template);

        try {
            Files.write(Path.of("outputs",String.format("%s.java", className)), body.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
