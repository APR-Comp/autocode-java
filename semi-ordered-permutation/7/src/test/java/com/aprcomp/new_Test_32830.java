package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_32830 {
    @Test(timeout=5000)
    public void test_32830(){
        assertEquals(12L, new Solution().semiOrderedPermutation( new int[]{10,15,8,1,13,14,16,3,12,7,5,6,11,2,9,4}) );
        }
}
