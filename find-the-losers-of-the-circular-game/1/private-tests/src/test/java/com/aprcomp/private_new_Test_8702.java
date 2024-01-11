package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_8702 {
    @Test(timeout=5000)
    public void test_8702(){
        assertArrayEquals(new int[]{2,3,4,6,8,9,10,11,12,14,16,17,18,19,20,22,23,24,26,27,28,29,30,31,32,33,34,36,38,40,42,44,45,46}, new Solution().circularGameLosers(46,4) );
        }
}
