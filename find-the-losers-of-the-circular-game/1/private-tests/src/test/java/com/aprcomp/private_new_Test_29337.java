package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_29337 {
    @Test(timeout=5000)
    public void test_29337(){
        assertArrayEquals(new int[]{5,6,8,9,10,13,14,15,17,18,19,20,21,23,24,25,26,27,28,30,31,32,33,34}, new Solution().circularGameLosers(34,1) );
        }
}
