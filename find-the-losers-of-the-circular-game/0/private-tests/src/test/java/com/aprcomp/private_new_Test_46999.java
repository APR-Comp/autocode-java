package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_46999 {
    @Test(timeout=5000)
    public void test_46999(){
        assertArrayEquals(new int[]{2,3}, new Solution().circularGameLosers(5,3) );
        }
}
