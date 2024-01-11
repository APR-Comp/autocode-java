package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_60924 {
    @Test(timeout=5000)
    public void test_60924(){
        assertEquals(10L, new Solution().semiOrderedPermutation( new int[]{1,9,10,6,2,3,17,15,14,13,16,11,7,12,5,8,4}) );
        }
}
