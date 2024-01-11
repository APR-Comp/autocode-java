package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_19162 {
    @Test(timeout=5000)
    public void test_19162(){
        assertArrayEquals(new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32}, new Solution().circularGameLosers(32,10) );
        }
}
