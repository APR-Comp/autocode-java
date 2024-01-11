
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertArrayEquals(new int[]{0,1,1,0,2}, new Solution().colorTheArray( 4, new int[][]{{0,2},{1,2},{3,1},{1,1},{2,1}}));
            }
    }
    