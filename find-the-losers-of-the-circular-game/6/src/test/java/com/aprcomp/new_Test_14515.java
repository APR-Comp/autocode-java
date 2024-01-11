package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_14515 {
    @Test(timeout=5000)
    public void test_14515(){
        assertArrayEquals(new int[]{2,4,5,7,8,10,14,15}, new Solution().circularGameLosers(17,45) );
        }
}
