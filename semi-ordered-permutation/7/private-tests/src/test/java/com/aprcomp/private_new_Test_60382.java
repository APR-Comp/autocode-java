package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_60382 {
    @Test(timeout=5000)
    public void test_60382(){
        assertEquals(7L, new Solution().semiOrderedPermutation( new int[]{1,9,5,2,7,6,3,8,4}) );
        }
}
