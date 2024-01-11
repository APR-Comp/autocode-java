package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_3221 {
    @Test(timeout=5000)
    public void test_3221(){
        assertEquals(210L, new Solution().countInterestingSubarrays( List.of(3594,65522,243138560,16777063,1,917508,920064,0,353703190,65522,1,234882303,235536384,353703424,60138,920074,353703424,353703190,60138,168427520),1,0  ) );
        }
}
