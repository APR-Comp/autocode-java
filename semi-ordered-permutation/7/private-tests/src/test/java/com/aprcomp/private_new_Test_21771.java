package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_21771 {
    @Test(timeout=5000)
    public void test_21771(){
        assertEquals(3L, new Solution().semiOrderedPermutation( new int[]{14,5,8,1,3,6,4,10,15,7,9,11,12,13,2,16}) );
        }
}
