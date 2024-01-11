package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_381 {
    @Test(timeout=5000)
    public void test_381(){
        assertEquals(791998723L, new Solution().maximumSumOfHeights( List.of(14086611,14024705,721420289,14086401,14024705,721420289,131071,33543925,14087424)) );
        }
}
