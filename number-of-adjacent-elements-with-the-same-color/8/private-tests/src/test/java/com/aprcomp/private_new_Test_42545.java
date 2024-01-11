package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_42545 {
    @Test(timeout=5000)
    public void test_42545(){
        assertArrayEquals( new int[]{0}, new Solution().colorTheArray(1,new int[][]{new int[]{0,1}}) );
        }
}
