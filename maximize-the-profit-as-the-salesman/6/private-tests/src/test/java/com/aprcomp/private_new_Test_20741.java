package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_20741 {
    @Test(timeout=5000)
    public void test_20741(){
        assertEquals(1, new Solution().maximizeTheProfit(1,List.of(List.of(0,0,1))) );
        }
}
