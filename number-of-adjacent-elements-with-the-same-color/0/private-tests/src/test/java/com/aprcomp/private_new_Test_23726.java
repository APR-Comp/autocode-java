package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_23726 {
    @Test(timeout=5000)
    public void test_23726(){
        assertArrayEquals( new int[]{0,1}, new Solution().colorTheArray(9,new int[][]{new int[]{1,1},new int[]{0,1}}) );
        }
}
