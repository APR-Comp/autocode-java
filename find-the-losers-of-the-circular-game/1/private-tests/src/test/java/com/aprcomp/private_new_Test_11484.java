package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_11484 {
    @Test(timeout=5000)
    public void test_11484(){
        assertArrayEquals(new int[]{2,4,6,7,12,13}, new Solution().circularGameLosers(13,36) );
        }
}
