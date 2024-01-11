package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_18704 {
    @Test(timeout=5000)
    public void test_18704(){
        assertEquals(13L, new Solution().semiOrderedPermutation( new int[]{2,25,9,5,10,1,15,11,20,18,23,28,4,22,12,13,27,14,16,24,8,30,6,29,7,19,17,26,3,21}) );
        }
}
