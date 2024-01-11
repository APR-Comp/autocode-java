package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_34452 {
    @Test(timeout=5000)
    public void test_34452(){
        assertArrayEquals(new int[]{2}, new Solution().circularGameLosers(3,17) );
        }
}
