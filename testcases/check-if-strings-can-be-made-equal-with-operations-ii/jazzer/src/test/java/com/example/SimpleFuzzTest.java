package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
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
                assertEquals(%b, new Solution().checkStrings( \"%s\",\"%s\") );
                }
        }
                """;

static int c = 0;
    @FuzzTest(maxDuration = "1s")
    void fuzzSolution(FuzzedDataProvider data) {
        
        int length = data.consumeInt(1,10000);

        StringBuilder a= new StringBuilder();
        StringBuilder b = new StringBuilder();

        for(int i =0;i<length;i++){
            a.append(data.consumeChar('a', 'z'));
            b.append(data.consumeChar('a', 'z'));
        }
        c++;

        
        String className = String.format("%s_new_Test_%d",System.getenv("TEST_TYPE"),c);
        boolean x = new Solution().checkStrings(a.toString(),b.toString());
        String body = String.format(template, className, c, x,a.toString(),b.toString());
        try {
            Files.write(Path.of("outputs",String.format("%s.java",className)), body.getBytes());
        } catch (IOException e) {
        }
    }
}
