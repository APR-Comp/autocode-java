package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_25523 {
    @Test(timeout=5000)
    public void test_25523(){
        assertArrayEquals(new int[]{3,4,6,11,12,13,15,16,17,18,20,21,22,27,29,30,33,37}, new Solution().circularGameLosers(37,24) );
        }
}
