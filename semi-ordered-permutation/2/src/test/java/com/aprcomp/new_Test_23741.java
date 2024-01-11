package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_23741 {
    @Test(timeout=5000)
    public void test_23741(){
        assertEquals(48L, new Solution().semiOrderedPermutation( new int[]{12,7,18,19,38,28,37,10,16,31,24,33,11,21,23,32,42,34,8,14,35,27,9,20,1,4,30,15,40,22,6,25,39,26,41,5,29,13,3,36,2,17}) );
        }
}
