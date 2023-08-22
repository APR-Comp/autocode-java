package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;

public class PublicSolutionTest {
    @Test(timeout=5000)
    public void test1(){
        int arr[] = {2,2,3,3};
        assertEquals(14, wateringPlants(arr, 5));
    }

    @Test(timeout=5000)
    public void test2(){
        int arr[] = {1,1,1,4,2,3};
        assertEquals(30, wateringPlants(arr, 4));
    }

    @Test(timeout=5000)
    public void test3(){
        int arr[] = {7,7,7,7,7,7,7};
        assertEquals(49, wateringPlants(arr, 8));
    }
    @Test(timeout=5000)
    public void test4(){
        int arr[] = {7,7};
        assertEquals(3, wateringPlants(arr, 14));
    }

    @Test(timeout=5000)
    public void test5(){
        int arr[] = {};
        assertEquals(0, wateringPlants(arr, 14));
    }
}