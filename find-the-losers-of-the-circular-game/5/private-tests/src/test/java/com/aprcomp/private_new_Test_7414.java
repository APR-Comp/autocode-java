package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_7414 {
    @Test(timeout=5000)
    public void test_7414(){
        assertArrayEquals(new int[]{2,3,4}, new Solution().circularGameLosers(4,20) );
        }
}
