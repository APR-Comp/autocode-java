package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_52376 {
    @Test(timeout=5000)
    public void test_52376(){
        assertArrayEquals(new int[]{3,8,12,13,14,15,17,20,21,23,25,27,28,31,33,34,35,36}, new Solution().circularGameLosers(37,1) );
        }
}
