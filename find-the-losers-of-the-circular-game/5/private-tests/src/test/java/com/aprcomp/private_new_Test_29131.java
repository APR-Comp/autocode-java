package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_29131 {
    @Test(timeout=5000)
    public void test_29131(){
        assertArrayEquals(new int[]{3,5}, new Solution().circularGameLosers(5,1) );
        }
}
