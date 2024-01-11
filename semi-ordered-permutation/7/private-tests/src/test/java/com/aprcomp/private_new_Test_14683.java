package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_14683 {
    @Test(timeout=5000)
    public void test_14683(){
        assertEquals(17L, new Solution().semiOrderedPermutation( new int[]{18,27,21,15,4,22,12,13,5,10,23,1,17,16,28,20,11,19,3,9,2,7,29,24,26,8,6,25,14}) );
        }
}
