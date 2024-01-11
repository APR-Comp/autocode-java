package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_24286 {
    @Test(timeout=5000)
    public void test_24286(){
        assertEquals(71L, new Solution().semiOrderedPermutation( new int[]{30,24,42,18,11,17,31,45,33,7,20,3,43,28,5,37,22,14,29,47,21,44,25,35,36,6,41,27,12,13,9,19,8,34,39,2,16,46,23,40,15,10,38,32,26,1,4}) );
        }
}
