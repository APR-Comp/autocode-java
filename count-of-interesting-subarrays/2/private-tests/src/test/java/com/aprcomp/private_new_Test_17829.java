package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_17829 {
    @Test(timeout=5000)
    public void test_17829(){
        assertEquals(28L, new Solution().countInterestingSubarrays( List.of(655370,167772160,65536,167837695,167775754,167772160,167772160),11,0  ) );
        }
}
