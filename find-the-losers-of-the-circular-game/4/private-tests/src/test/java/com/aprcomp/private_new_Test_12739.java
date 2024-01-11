package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_12739 {
    @Test(timeout=5000)
    public void test_12739(){
        assertArrayEquals(new int[]{2,3,5,6,8,9,11,13,14,15,16,18,20,21,22,23,24,25,26,27,28,29,32,33}, new Solution().circularGameLosers(34,3) );
        }
}
