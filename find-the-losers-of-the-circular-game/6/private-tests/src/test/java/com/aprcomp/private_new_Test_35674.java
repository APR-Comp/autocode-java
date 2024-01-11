package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_35674 {
    @Test(timeout=5000)
    public void test_35674(){
        assertArrayEquals(new int[]{5,9,10,12,14,15,18,21,23,26,27,28,30,31,32,33,34,38,40,41,42}, new Solution().circularGameLosers(43,1) );
        }
}
