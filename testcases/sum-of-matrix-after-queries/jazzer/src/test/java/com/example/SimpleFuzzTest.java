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
                    assertEquals(%dL, new Solution().matrixSumQueries(%d,%s) );
                    }
            }
                    """;

    static int c = 0;

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

    @FuzzTest(maxDuration = "10s")
    void fuzzSolution(FuzzedDataProvider data) {

        int n = data.consumeInt(1, 1000);
        int length = data.consumeInt(1, 500);

        int[][] queries = new int[length][3];

        for (int i = 0; i < length; i++) {
            queries[i][0] = data.consumeInt(0, 1);
            queries[i][1] = data.consumeInt(0, n-1);
            queries[i][2] = data.consumeInt(0, 10000);
        }

        c++;
        long x = new Solution().matrixSumQueries(n, queries);
        String className = String.format("%s_new_Test_%d",System.getenv("TEST_TYPE"),c); 
        String body = String.format(template, className, c, x,n, convert(queries));

        try {
            Files.write(Path.of("outputs",String.format("%s.java", className)), body.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
