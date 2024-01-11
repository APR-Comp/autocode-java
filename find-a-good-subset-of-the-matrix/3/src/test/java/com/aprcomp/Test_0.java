
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertEquals(Arrays.asList(0,1), new Solution().goodSubsetofBinaryMatrix( new int[][]{ {0,1,1,0},{0,0,0,1},{1,1,1,1}})  );
            }
    }
    