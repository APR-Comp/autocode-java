
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertEquals(3, new Solution().paintWalls( new int[]{1,2,3,2}, new int[]{1,2,3,2}));
            }
    }
    