package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_58549 {
    @Test(timeout=5000)
    public void test_58549(){
        assertArrayEquals(new int[]{2,3,4,5,6,8,9,10,11,12,13,14,16,17,18,19,20,21,23,24,25,26,27,29,30,31,32,34,35,36,38,39,41}, new Solution().circularGameLosers(42,41) );
        }
}
