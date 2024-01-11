package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_5295 {
    @Test(timeout=5000)
    public void test_5295(){
        assertEquals(28L, new Solution().countInterestingSubarrays( List.of(0,1,1,1,65537,193,234881038,655360),15,0  ) );
        }
}
