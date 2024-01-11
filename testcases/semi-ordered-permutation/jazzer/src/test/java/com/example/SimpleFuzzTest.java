package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
                    assertEquals(%dL, new Solution().semiOrderedPermutation( new int[]{%s}) );
                    }
            }
                    """;

    static int c = 0;

    @FuzzTest(maxDuration = "1s")
    void fuzzSolution(FuzzedDataProvider data) {
        int length = data.consumeInt(2, 50);

        int[] inputs = new int[length];

        List<Integer> permutation = IntStream.range(1, length+1).mapToObj(x -> x).collect(Collectors.toList());

        Collections.shuffle(permutation);

        for(int i =0 ; i<inputs.length;i++){
            inputs[i] = permutation.get(i);
        }

        c++;
        long x = new Solution().semiOrderedPermutation(inputs);
        String className = String.format("%s_new_Test_%d",System.getenv("TEST_TYPE"),c); 
        String body = String.format(template, className, c, x,
                Arrays.stream(inputs).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        
        try {
            Files.write(Path.of("outputs",String.format("%s.java", className)), body.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
