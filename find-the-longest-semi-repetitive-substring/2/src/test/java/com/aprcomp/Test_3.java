
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_3 {
        @Test(timeout=5000)
        public void test_3(){
            assertEquals(4, new Solution().longestSemiRepetitiveSubstring( "1011"));
            }
    }
    