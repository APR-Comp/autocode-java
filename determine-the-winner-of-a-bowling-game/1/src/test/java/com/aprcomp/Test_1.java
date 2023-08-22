
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_1 {
        @Test(timeout=5000)
        public void test_1(){
            assertEquals(2, new Solution().isWinner( new int[]{3,5,7,6}, new int[]{8,10,10,2}));
            }
    }
    