package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_49784 {
    @Test(timeout=5000)
    public void test_49784(){
        assertEquals(43L, new Solution().countInterestingSubarrays( List.of(242,1,1,1,1,1,983039,3600,16777206,1,1,235929614,655360),15,0  ) );
        }
}
