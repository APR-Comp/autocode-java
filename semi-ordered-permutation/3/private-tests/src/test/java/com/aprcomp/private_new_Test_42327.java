package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_42327 {
    @Test(timeout=5000)
    public void test_42327(){
        assertEquals(3L, new Solution().semiOrderedPermutation( new int[]{4,1,3,2}) );
        }
}
