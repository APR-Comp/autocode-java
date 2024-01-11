package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_6241 {
    @Test(timeout=5000)
    public void test_6241(){
        assertEquals(64L, new Solution().semiOrderedPermutation( new int[]{19,27,37,4,20,39,15,10,25,18,29,21,32,28,7,42,3,8,23,11,17,14,12,36,35,22,16,2,38,34,33,5,13,30,24,40,9,26,6,1,31,41}) );
        }
}
