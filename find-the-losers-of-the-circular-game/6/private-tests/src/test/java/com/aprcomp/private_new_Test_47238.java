package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_47238 {
    @Test(timeout=5000)
    public void test_47238(){
        assertArrayEquals(new int[]{2,3,4,5,7,9,11,12,13,15,16,17,18,19,20,21,22,23,24,25,26,27,29,30,32,33,34,35,36,37,39,40,41,44,45,46,47,48,49}, new Solution().circularGameLosers(49,9) );
        }
}
