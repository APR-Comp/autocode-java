package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_14026 {
    @Test(timeout=5000)
    public void test_14026(){
        assertArrayEquals(new int[]{3,5,6,8,9,10,12,13,14,15,17,18,19,20,21}, new Solution().circularGameLosers(22,1) );
        }
}
