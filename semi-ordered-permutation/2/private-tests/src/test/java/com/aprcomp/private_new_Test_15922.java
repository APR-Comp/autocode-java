package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_15922 {
    @Test(timeout=5000)
    public void test_15922(){
        assertEquals(30L, new Solution().semiOrderedPermutation( new int[]{15,21,8,18,3,7,14,12,2,11,6,16,1,5,4,9,13,20,19,10,17}) );
        }
}
