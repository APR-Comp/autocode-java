package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_20588 {
    @Test(timeout=5000)
    public void test_20588(){
        assertEquals(6L, new Solution().countInterestingSubarrays( List.of(10,16779776,235538952),1,0  ) );
        }
}
