package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_25684 {
    @Test(timeout=5000)
    public void test_25684(){
        assertEquals(18L, new Solution().semiOrderedPermutation( new int[]{10,11,15,18,23,4,2,14,24,1,19,13,6,16,3,8,26,22,20,5,21,12,9,7,17,25}) );
        }
}
