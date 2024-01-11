package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_48010 {
    @Test(timeout=5000)
    public void test_48010(){
        assertArrayEquals(new int[]{2,3,4,6,7,8,9,10,12,13,14,15,17,18,19,21,22,24}, new Solution().circularGameLosers(25,49) );
        }
}
