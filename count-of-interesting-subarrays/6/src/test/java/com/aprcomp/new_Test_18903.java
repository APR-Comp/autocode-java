package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_18903 {
    @Test(timeout=5000)
    public void test_18903(){
        assertEquals(6L, new Solution().countInterestingSubarrays( List.of(10,2560,235538944),11,0  ) );
        }
}
