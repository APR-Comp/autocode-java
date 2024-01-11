package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_54105 {
    @Test(timeout=5000)
    public void test_54105(){
        assertEquals(136L, new Solution().countInterestingSubarrays( List.of(16777206,14680063,2097118464,2088533117,2088533117,2080430337,659587,256,268435679,8158333,1920103027,1920103011,1920103027,1920103027,1920103027,184520077),1,0  ) );
        }
}
