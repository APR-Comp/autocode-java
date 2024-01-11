package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_27478 {
    @Test(timeout=5000)
    public void test_27478(){
        assertArrayEquals(new int[]{2,3,4,5,6,7,8,9,11,12,13,14,15,17,18,20,21,22,23,24,25,26,27}, new Solution().circularGameLosers(27,15) );
        }
}
