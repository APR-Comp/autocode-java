package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_17078 {
    @Test(timeout=5000)
    public void test_17078(){
        assertArrayEquals(new int[]{2,3,4,6,7,8,9,12,14,15}, new Solution().circularGameLosers(15,49) );
        }
}
