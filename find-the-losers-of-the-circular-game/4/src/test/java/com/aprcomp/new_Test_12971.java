package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_12971 {
    @Test(timeout=5000)
    public void test_12971(){
        assertArrayEquals(new int[]{2,3,4,5,6,8,10}, new Solution().circularGameLosers(10,6) );
        }
}
