
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_3 {
        @Test(timeout=5000)
        public void test_3(){
            assertEquals(1, new Solution().isWinner( new int[]{10,2,2,3}, new int[]{3,8,4,5}));
            }
    }
    
