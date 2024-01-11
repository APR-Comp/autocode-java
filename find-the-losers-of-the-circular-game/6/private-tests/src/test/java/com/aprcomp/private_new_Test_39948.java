package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_39948 {
    @Test(timeout=5000)
    public void test_39948(){
        assertArrayEquals(new int[]{5,6,8,10,12,13}, new Solution().circularGameLosers(13,1) );
        }
}
