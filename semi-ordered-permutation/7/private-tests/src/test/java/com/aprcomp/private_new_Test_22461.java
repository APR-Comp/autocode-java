package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_22461 {
    @Test(timeout=5000)
    public void test_22461(){
        assertEquals(20L, new Solution().semiOrderedPermutation( new int[]{2,9,17,11,4,19,14,12,15,13,18,6,16,3,7,5,10,20,8,1}) );
        }
}
