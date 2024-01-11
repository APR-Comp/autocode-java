package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_13042 {
    @Test(timeout=5000)
    public void test_13042(){
        assertArrayEquals( new int[]{0}, new Solution().colorTheArray(33,new int[][]{new int[]{0,1}}) );
        }
}
