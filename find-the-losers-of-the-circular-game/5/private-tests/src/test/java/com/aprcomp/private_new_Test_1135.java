package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_1135 {
    @Test(timeout=5000)
    public void test_1135(){
        assertArrayEquals(new int[]{3,4,5,7,9,12,13,14,15,17,18,19,20,26,31,32,34,36,40,41,43,44,47}, new Solution().circularGameLosers(47,28) );
        }
}
