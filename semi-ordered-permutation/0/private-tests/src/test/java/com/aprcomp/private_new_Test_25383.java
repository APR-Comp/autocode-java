package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_25383 {
    @Test(timeout=5000)
    public void test_25383(){
        assertEquals(4L, new Solution().semiOrderedPermutation( new int[]{9,8,10,7,1,6,3,4,11,5,2,12}) );
        }
}
