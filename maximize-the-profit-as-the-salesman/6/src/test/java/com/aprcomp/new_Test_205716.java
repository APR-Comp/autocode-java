package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_205716 {
    @Test(timeout=5000)
    public void test_205716(){
        assertEquals(1, new Solution().maximizeTheProfit(643,List.of(List.of(0,0,1))) );
        }
}
