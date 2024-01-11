package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_40760 {
    @Test(timeout=5000)
    public void test_40760(){
        assertArrayEquals(new int[]{3,5,8,9,10,12,13,14,15,18,19,20,21,23,24,25,26,27,28,30,31,32,33,34,35,36,38,39,40,41,42,43,44,45,47,48,49,50}, new Solution().circularGameLosers(50,1) );
        }
}
