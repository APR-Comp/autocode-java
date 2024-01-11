package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_21483 {
    @Test(timeout=5000)
    public void test_21483(){
        assertEquals(36L, new Solution().countInterestingSubarrays( List.of(33619954,1,327679,167772174,369098738,353703190,353703190,168427520),1,0  ) );
        }
}
