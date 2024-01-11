package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_23363 {
    @Test(timeout=5000)
    public void test_23363(){
        assertEquals(16515072L, new Solution().maximumSumOfHeights( List.of(0,0,0,0,64512,0,0,0,0,0,0,0,16515072,0,0,0,0)) );
        }
}
