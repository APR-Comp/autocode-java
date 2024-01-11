package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_18210 {
    @Test(timeout=5000)
    public void test_18210(){
        assertEquals(8L, new Solution().semiOrderedPermutation( new int[]{5,2,4,3,8,6,1,7}) );
        }
}
