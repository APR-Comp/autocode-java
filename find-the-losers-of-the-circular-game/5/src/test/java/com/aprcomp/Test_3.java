package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class Test_3 {
    @Test(timeout=5000)
    public void test_3(){
        assertArrayEquals( new int[]{3,5,6}, new Solution().circularGameLosers( 6,1));
        }
}
