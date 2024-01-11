package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_53743 {
    @Test(timeout=5000)
    public void test_53743(){
        assertEquals(15L, new Solution().semiOrderedPermutation( new int[]{8,14,4,9,15,6,1,17,11,3,16,5,7,10,13,12,2}) );
        }
}
