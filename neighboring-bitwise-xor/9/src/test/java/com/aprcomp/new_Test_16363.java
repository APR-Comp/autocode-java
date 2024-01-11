package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_16363 {
    @Test(timeout=5000)
    public void test_16363(){
        assertEquals(false, new Solution().doesValidArrayExist( new int[]{1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,1,1,1,0,1,1,1}) );
        }
}
