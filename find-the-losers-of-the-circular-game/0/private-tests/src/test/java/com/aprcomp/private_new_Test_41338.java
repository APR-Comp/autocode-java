package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_41338 {
    @Test(timeout=5000)
    public void test_41338(){
        assertArrayEquals(new int[]{2,3,4,6,7,8,9,10,11,14,16,17,18,19,20,21,22,23,24,26,27,28,29,30,31,32,33,35,37,38,39,40,42,43,44,45,46,48,49}, new Solution().circularGameLosers(49,4) );
        }
}
