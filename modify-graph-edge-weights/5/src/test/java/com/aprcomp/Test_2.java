
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_2 {
        @Test(timeout=5000)
        public void test_2(){
            assertArrayEquals(new int[][]{{1,0,4},{1,2,3},{2,3,5},{0,3,1}}, new Solution().modifiedGraphEdges( 4, new int[][]{{1,0,4},{1,2,3},{2,3,5},{0,3,-1}}, 0, 2, 6));
            }
    }
    