package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_13891 {
    @Test(timeout=5000)
    public void test_13891(){
        assertEquals(false, new Solution().doesValidArrayExist( new int[]{0,1,0,1,0,1,0,0,0,0,0,0,0}) );
        }
}
