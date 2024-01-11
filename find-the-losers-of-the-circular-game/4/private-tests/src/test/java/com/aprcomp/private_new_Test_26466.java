package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_26466 {
    @Test(timeout=5000)
    public void test_26466(){
        assertArrayEquals(new int[]{2,3,4,5,6,7,8,9}, new Solution().circularGameLosers(9,9) );
        }
}
