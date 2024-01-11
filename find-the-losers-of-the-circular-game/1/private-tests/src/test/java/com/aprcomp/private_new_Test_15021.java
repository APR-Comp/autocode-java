package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_15021 {
    @Test(timeout=5000)
    public void test_15021(){
        assertArrayEquals(new int[]{4,5,7,9,10,11,12,13,14,15,17,18,20,21,22}, new Solution().circularGameLosers(22,15) );
        }
}
