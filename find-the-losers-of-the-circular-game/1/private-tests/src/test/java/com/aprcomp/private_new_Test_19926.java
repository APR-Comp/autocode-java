package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_19926 {
    @Test(timeout=5000)
    public void test_19926(){
        assertArrayEquals(new int[]{2,6,7,8,9,11,14,15,17,19,21,22,25,27,28,29,30,34}, new Solution().circularGameLosers(37,49) );
        }
}
