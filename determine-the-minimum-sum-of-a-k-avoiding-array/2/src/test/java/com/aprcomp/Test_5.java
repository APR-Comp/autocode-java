
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_5 {
        @Test(timeout=5000)
        public void test_5(){
            assertEquals(14, new Solution().minimumSum(4,5));
            }
    }
    