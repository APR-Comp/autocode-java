package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_15490 {
    @Test(timeout=5000)
    public void test_15490(){
        assertEquals(3L, new Solution().semiOrderedPermutation( new int[]{3,2,1}) );
        }
}
