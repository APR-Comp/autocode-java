package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_25154 {
    @Test(timeout=5000)
    public void test_25154(){
        assertEquals(10L, new Solution().countInterestingSubarrays( List.of(10,2560,16776996,184549130),11,0  ) );
        }
}
