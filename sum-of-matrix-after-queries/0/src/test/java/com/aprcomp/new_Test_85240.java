package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_85240 {
    @Test(timeout=5000)
    public void test_85240(){
        assertEquals(0L, new Solution().matrixSumQueries(1,new int[][]{new int[]{1,0,749},new int[]{0,0,2698},new int[]{0,0,0},new int[]{0,0,5325},new int[]{1,0,0},new int[]{0,0,5633},new int[]{0,0,1},new int[]{0,0,4626},new int[]{0,0,6505},new int[]{0,0,8654},new int[]{0,0,4626},new int[]{0,0,266},new int[]{0,0,1502},new int[]{0,0,284},new int[]{0,0,3365},new int[]{0,0,5529},new int[]{1,0,5279},new int[]{0,0,1280},new int[]{0,0,2954},new int[]{0,0,0},new int[]{0,0,18},new int[]{0,0,4626},new int[]{0,0,4672},new int[]{0,0,3706},new int[]{0,0,4626},new int[]{0,0,4730},new int[]{0,0,5409},new int[]{0,0,3995},new int[]{0,0,5318},new int[]{1,0,496},new int[]{1,0,0},new int[]{0,0,5529},new int[]{0,0,5529},new int[]{0,0,255},new int[]{1,0,5529},new int[]{1,0,5529},new int[]{1,0,0},new int[]{0,0,162},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0}}) );
        }
}