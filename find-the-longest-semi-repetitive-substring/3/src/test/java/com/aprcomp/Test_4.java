
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_4 {
        @Test(timeout=5000)
        public void test_4(){
            assertEquals(2, new Solution().longestSemiRepetitiveSubstring( "10"));
            }
    }
    