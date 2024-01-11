package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_17085 {
    @Test(timeout=5000)
    public void test_17085(){
        assertArrayEquals(new int[]{3,5,6,8,9}, new Solution().circularGameLosers(9,1) );
        }
}
