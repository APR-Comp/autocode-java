
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertEquals(2, new Solution().maxIncreasingCells( new int[][]{{3,1},{3,4}}));
            }
    }
    