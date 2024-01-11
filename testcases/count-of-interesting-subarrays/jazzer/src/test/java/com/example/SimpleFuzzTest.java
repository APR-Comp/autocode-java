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
                    assertEquals(%dL, new Solution().countInterestingSubarrays( List.of(%s),%d,%d  ) );
                    }
            }
                    """;

    static int c = 0;

    @FuzzTest(maxDuration = "1s")
    void fuzzSolution(FuzzedDataProvider data) {

        int mod = data.consumeInt(1, (int) 1e9);
        int k = data.consumeInt(0, mod);
        List<Integer> a = Arrays.stream(data.consumeInts(1000)).boxed().map(Math::abs)
                .collect(Collectors.toList());

        c++;
        long x = new Solution().countInterestingSubarrays(a, mod, k);
        String className = String.format("%s_new_Test_%d",System.getenv("TEST_TYPE"),c);
        String body = String.format(template, className, c, x,
                a.stream().map(String::valueOf).collect(Collectors.joining(",")), mod, k);

        try {
            Files.write(Path.of("outputs", String.format("%s.java", className)), body.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
