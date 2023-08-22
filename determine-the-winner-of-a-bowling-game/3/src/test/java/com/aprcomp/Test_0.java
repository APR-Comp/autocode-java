
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_0 {
        @Test(timeout=5000)
        public void test_0(){
            assertEquals(1, new Solution().isWinner( new int[]{4,10,7,9}, new int[]{6,5,2,3}));
            }
    }
    