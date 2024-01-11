
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertEquals(15, new Solution().matrixSum( new int[][]{{7,2,1},{6,4,2},{6,5,3},{3,2,1}}));
            }
    }
    