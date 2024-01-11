package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_63256 {
    @Test(timeout=5000)
    public void test_63256(){
        assertArrayEquals(new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17}, new Solution().circularGameLosers(17,17) );
        }
}
