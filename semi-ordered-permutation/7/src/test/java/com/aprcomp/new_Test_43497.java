package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_43497 {
    @Test(timeout=5000)
    public void test_43497(){
        assertEquals(10L, new Solution().semiOrderedPermutation( new int[]{9,7,6,1,2,8,5,3,4}) );
        }
}
