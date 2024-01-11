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
                    assertEquals(%d, new Solution().matrixSum(%s));
                    }
            }
                    """;

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

    @FuzzTest(maxDuration = "20s")
    void fuzzSolution(FuzzedDataProvider data) {
        int m = data.consumeInt(1, 50);
        int n = data.consumeInt(1, 50);
        int[][] grid = new int[m][n];
        int[][] gridOrig = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (grid[i] == null) {
                grid[i] = new int[n];
                gridOrig[i] = new int[n];
            }
            for (int j = 0; j < n; j++) {
                int x = data.consumeInt(0, 1000);
                grid[i][j] = x;
                gridOrig[i][j] = x; 
            }
        }

        co++;
        int x = new Solution().matrixSum(grid);
        String className = String.format("%s_new_Test_%d",System.getenv("TEST_TYPE"),co); 
        String body = String.format(template, className, co, x,
                convert(gridOrig));

        try {
            Files.write(Path.of("outputs",String.format("%s.java", className)), body.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
