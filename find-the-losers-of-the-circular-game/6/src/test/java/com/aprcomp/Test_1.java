
package com.aprcomp;

import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;

public class Test_1 {
    @Test(timeout = 5000)
    public void test_1() {
        assertArrayEquals(new int[] { 2, 3, 4 }, new Solution().circularGameLosers(4, 4));
    }
}
