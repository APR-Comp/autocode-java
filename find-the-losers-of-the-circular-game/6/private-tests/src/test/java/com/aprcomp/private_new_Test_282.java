package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_282 {
    @Test(timeout=5000)
    public void test_282(){
        assertArrayEquals(new int[]{2,3,4,5,6,7,9,11,12,13,15,16,18,19,20,21,22,23,24,25,26,29,30,31,32,33,34,35,36,37,39,40,41,42,44,45,46,47,48}, new Solution().circularGameLosers(49,37) );
        }
}
