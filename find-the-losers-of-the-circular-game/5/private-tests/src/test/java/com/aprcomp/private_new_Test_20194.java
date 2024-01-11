package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_20194 {
    @Test(timeout=5000)
    public void test_20194(){
        assertArrayEquals(new int[]{2,3,4,6,7,8,9,11,12,13,18,20,21,24,28,31,32,34}, new Solution().circularGameLosers(37,22) );
        }
}
