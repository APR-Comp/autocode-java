package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_23528 {
    @Test(timeout=5000)
    public void test_23528(){
        assertArrayEquals(new int[]{2,3,5,6,8}, new Solution().circularGameLosers(9,44) );
        }
}
