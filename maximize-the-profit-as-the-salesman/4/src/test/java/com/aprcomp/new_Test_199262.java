package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_199262 {
    @Test(timeout=5000)
    public void test_199262(){
        assertEquals(60, new Solution().maximizeTheProfit(1,List.of(List.of(0,0,60),List.of(0,0,1),List.of(0,0,1),List.of(0,0,1),List.of(0,0,1))) );
        }
}
