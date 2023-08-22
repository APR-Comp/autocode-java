
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertArrayEquals(new int[][] {{4,1,1},{2,0,1},{0,3,3},{4,3,1}}, new Solution().modifiedGraphEdges( 5, new int[][]{{4,1,-1},{2,0,-1},{0,3,-1},{4,3,-1}}, 0, 1, 5));
            }
    }
    