package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_52189 {
    @Test(timeout=5000)
    public void test_52189(){
        assertEquals(53L, new Solution().semiOrderedPermutation( new int[]{10,36,18,35,26,32,8,9,28,21,38,42,41,11,24,40,37,3,5,27,34,12,7,4,1,33,23,25,16,19,29,20,22,39,2,31,14,13,6,15,30,17}) );
        }
}
