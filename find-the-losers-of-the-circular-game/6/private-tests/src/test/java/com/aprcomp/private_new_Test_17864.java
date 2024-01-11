package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_17864 {
    @Test(timeout=5000)
    public void test_17864(){
        assertArrayEquals(new int[]{3,7,9,10,11,12,15,17,20,21,22,23,25,29}, new Solution().circularGameLosers(29,25) );
        }
}
