
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_2 {
        @Test(timeout=5000)
        public void test_2(){
            assertArrayEquals(new int[]{1}, new Solution().distinctDifferenceArray( new int[]{1}));
            }
    }
    
