package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_40482 {
    @Test(timeout=5000)
    public void test_40482(){
        assertEquals(3L, new Solution().semiOrderedPermutation( new int[]{2,4,1,3,6,5}) );
        }
}
