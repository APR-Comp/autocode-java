package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;

public class PublicSolutionTest {


    @Test(timeout=5000)
    public void test1(){
        int arr[] = {1,2,5,2,3};
        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(1);
        arr2.add(2);
        assertEquals(arr2, targetIndices(arr, 2));
    }

    @Test(timeout=5000)
    public void test2(){
        int arr[] = {1,2,5,2,3};
        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(3);
        assertEquals(arr2, targetIndices(arr, 3));
    }

    @Test(timeout=5000)
    public void test3(){
        int arr[] = {1,2,5,2,3};
        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(4);
        assertEquals(arr2, targetIndices(arr, 5));
    }

    @Test(timeout=5000)
    public void test4(){
        int arr[] = {1};
        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(0);
        assertEquals(arr2, targetIndices(arr, 1));
    }


}