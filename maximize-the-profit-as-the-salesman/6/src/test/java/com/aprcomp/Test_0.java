
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertEquals(3, new Solution().maximizeTheProfit( 5, Arrays.asList( Arrays.asList(0,0,1),Arrays.asList(0,2,2),Arrays.asList(1,3,2))));
            }
    }
    