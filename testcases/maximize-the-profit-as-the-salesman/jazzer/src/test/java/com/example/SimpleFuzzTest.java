package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
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
                    assertEquals(%d, new Solution().maximizeTheProfit(%d,%s) );
                    }
            }
                    """;

    static int c = 0;

    @FuzzTest(maxDuration = "20s")
    void fuzzSolution(FuzzedDataProvider data) {
        int n = data.consumeInt(1, 2000);

        List<List<Integer>> offers = new ArrayList<List<Integer>>();
        int offerCount = data.consumeInt(1, 100);
        for (int i = 0; i < offerCount; i++) {
            int start = data.consumeInt(0, n - 1);
            int end = data.consumeInt(start, n - 1);
            int gold = data.consumeInt(1, 1000);
            offers.add(List.of(start, end, gold));
        }

        c++;
        int x = new Solution().maximizeTheProfit(n, offers);
        String className = String.format("%s_new_Test_%d",System.getenv("TEST_TYPE"),c); 
        String body = String.format(template, className, c, x, n,
                "List.of(" + (offers.stream()
                        .map(y -> ("List.of(" + y.stream().map(String::valueOf).collect(Collectors.joining(",")) + ")"))
                        .collect(Collectors.joining(","))) + ")");

        try {
            Files.write(Path.of("outputs",String.format("%s.java", className)), body.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
