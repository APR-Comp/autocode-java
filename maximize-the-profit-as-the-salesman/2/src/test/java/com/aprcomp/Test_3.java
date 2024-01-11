
package com.aprcomp;

import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;

public class Test_3 {
    @Test(timeout = 5000)
    public void test_3() {
        assertEquals(20, new Solution().maximizeTheProfit(15,

                Arrays.asList(Arrays.asList(5, 5, 10), Arrays.asList(2, 6, 6), Arrays.asList(8, 11, 5),
                        Arrays.asList(7, 11, 9), Arrays.asList(2, 4, 1), Arrays.asList(3, 8, 5), Arrays.asList(0, 6, 9),
                        Arrays.asList(0, 10, 5), Arrays.asList(5, 10, 8), Arrays.asList(4, 5, 1))));
    }
}
