package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_42149 {
    @Test(timeout=5000)
    public void test_42149(){
        assertEquals(3L, new Solution().countInterestingSubarrays( List.of(621678090,0),1,0  ) );
        }
}
