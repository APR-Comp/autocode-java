package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_31540 {
    @Test(timeout=5000)
    public void test_31540(){
        assertArrayEquals(new int[]{2,3,4,5,6,8,9,10,11,12,14,16,17,18}, new Solution().circularGameLosers(18,50) );
        }
}
