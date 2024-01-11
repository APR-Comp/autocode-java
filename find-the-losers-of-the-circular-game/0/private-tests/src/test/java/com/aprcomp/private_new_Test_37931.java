package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_37931 {
    @Test(timeout=5000)
    public void test_37931(){
        assertArrayEquals(new int[]{3,5,6}, new Solution().circularGameLosers(7,1) );
        }
}
