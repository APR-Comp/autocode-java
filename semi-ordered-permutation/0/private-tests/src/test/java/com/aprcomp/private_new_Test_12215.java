package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_12215 {
    @Test(timeout=5000)
    public void test_12215(){
        assertEquals(5L, new Solution().semiOrderedPermutation( new int[]{4,3,7,1,5,8,2,6}) );
        }
}
