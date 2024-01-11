package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_7123 {
    @Test(timeout=5000)
    public void test_7123(){
        assertEquals(6L, new Solution().semiOrderedPermutation( new int[]{29,19,26,1,25,21,31,13,36,3,2,33,9,16,35,12,14,20,23,8,24,37,28,22,17,11,10,5,18,15,6,7,4,32,38,27,34,30}) );
        }
}
