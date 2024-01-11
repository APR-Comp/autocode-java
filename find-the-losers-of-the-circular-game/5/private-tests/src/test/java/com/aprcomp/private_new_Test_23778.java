package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_23778 {
    @Test(timeout=5000)
    public void test_23778(){
        assertArrayEquals(new int[]{2,3,6,8,9,10,11,12,13,15,17,18,19,20,21,24,25,26,27,28,29,30,31,32,33,34,35,36}, new Solution().circularGameLosers(36,49) );
        }
}
