package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_37883 {
    @Test(timeout=5000)
    public void test_37883(){
        assertEquals(36L, new Solution().countInterestingSubarrays( List.of(242,1,1,5505025,1,1,234881038,655360),15,0  ) );
        }
}
