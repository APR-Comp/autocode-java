package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;

public class PublicSolutionTest {
    @Test(timeout=5000)
    public void test1(){
        String str = "leetcode";
        String str2 = "coats";
        assertEquals(7, minSteps(str, str2));
    }

    @Test(timeout=5000)
    public void test2(){
        String str = "night";
        String str2 = "thing";
        assertEquals(0, minSteps(str, str2));
    }
}