package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_3400 {
    @Test(timeout=5000)
    public void test_3400(){
        assertArrayEquals(new int[]{4,5,9,11,12,14,15,17}, new Solution().circularGameLosers(17,6) );
        }
}
