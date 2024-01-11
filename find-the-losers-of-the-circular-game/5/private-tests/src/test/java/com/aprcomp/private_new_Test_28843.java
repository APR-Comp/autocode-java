package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_28843 {
    @Test(timeout=5000)
    public void test_28843(){
        assertArrayEquals(new int[]{3,4,8,10,11,13,14,16}, new Solution().circularGameLosers(17,14) );
        }
}
