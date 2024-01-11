package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_53832 {
    @Test(timeout=5000)
    public void test_53832(){
        assertArrayEquals(new int[]{3}, new Solution().circularGameLosers(3,1) );
        }
}
