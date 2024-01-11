package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_3361 {
    @Test(timeout=5000)
    public void test_3361(){
        assertArrayEquals(new int[]{2,3,6,8,9,10,11,15,20,24,25,26,27,29,32,33,35,37}, new Solution().circularGameLosers(37,16) );
        }
}
