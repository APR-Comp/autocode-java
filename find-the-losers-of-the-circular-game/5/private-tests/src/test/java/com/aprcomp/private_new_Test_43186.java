package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_43186 {
    @Test(timeout=5000)
    public void test_43186(){
        assertArrayEquals(new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15}, new Solution().circularGameLosers(15,15) );
        }
}
