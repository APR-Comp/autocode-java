
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_1 {
        @Test(timeout=5000)
        public void test_1(){
            assertEquals(17, new Solution().matrixSumQueries( 3, new int[][]{{0,0,4},{0,1,2},{1,0,1},{0,2,3},{1,2,1}}));
            }
    }
    