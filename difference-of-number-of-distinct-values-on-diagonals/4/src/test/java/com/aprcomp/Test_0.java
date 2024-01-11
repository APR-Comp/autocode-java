
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertArrayEquals(
                new int[][]{{1,1,0},{1,0,1},{0,1,1}}, 
                new Solution().differenceOfDistinctValues( 
                    new int[][]{{1,2,3},{3,1,5},{3,2,1}}));
            }
    }
    