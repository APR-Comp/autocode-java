package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_31829 {
    @Test(timeout=5000)
    public void test_31829(){
        assertEquals(true, new Solution().doesValidArrayExist( new int[]{1,1,1,0,0,1}) );
        }
}
