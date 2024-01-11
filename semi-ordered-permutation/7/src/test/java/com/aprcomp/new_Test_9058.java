package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_9058 {
    @Test(timeout=5000)
    public void test_9058(){
        assertEquals(73L, new Solution().semiOrderedPermutation( new int[]{42,38,40,25,45,23,13,43,30,32,10,15,6,37,27,35,14,7,16,22,33,21,4,29,26,24,12,39,8,2,41,28,34,9,1,17,18,31,3,44,11,19,20,36,5}) );
        }
}
