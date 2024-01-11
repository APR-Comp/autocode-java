package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

public class SimpleFuzzTest {
    static String template = """
            package com.aprcomp;
            import java.util.*;
            import org.junit.Test;
            import static com.aprcomp.Solution.*;
            import static org.junit.Assert.*;
            public class %s {
                @Test(timeout=5000)
                public void test_%d(){
                    assertArrayEquals( new int[]{%s}, new Solution().colorTheArray(%d,%s) );
                    }
            }
                    """;

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

    static int c = 0;

    @FuzzTest(maxDuration = "10s")
    void fuzzSolution(FuzzedDataProvider data) {
        int n = data.consumeInt(1, 1000);
        int queryCount = data.consumeInt(1,1000);
        int[][] queries = new int[queryCount][2];

        for (int i = 0; i < queryCount; i++) {
            queries[i] = new int[] { data.consumeInt(0, n - 1), data.consumeInt(1, 10000) };
        }

        c++;
        int[] x = new Solution().colorTheArray(n, queries);
        String className = String.format("%s_new_Test_%d",System.getenv("TEST_TYPE"),c); 
        String body = String.format(template, className, c,
                Arrays.stream(x).mapToObj(String::valueOf).collect(Collectors.joining(",")),
                n, convert(queries));

        try {
            Files.write(Path.of("outputs",String.format("%s.java", className)), body.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
