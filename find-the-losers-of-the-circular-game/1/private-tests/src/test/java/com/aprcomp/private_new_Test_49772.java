package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_49772 {
    @Test(timeout=5000)
    public void test_49772(){
        assertArrayEquals(new int[]{2,4,6,7,8,9,10,12,13,14,16,17,19,20,21,22,23,26,27,28,29,30,32,33,34,35,37,38,39,40,41,42,43,44,45,46,47,48,49}, new Solution().circularGameLosers(49,17) );
        }
}
