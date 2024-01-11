
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertEquals(23, new Solution().matrixSumQueries( 3, new int[][]{{0,0,1},{1,2,2},{0,2,3},{1,0,4}}));
            }
    }
    