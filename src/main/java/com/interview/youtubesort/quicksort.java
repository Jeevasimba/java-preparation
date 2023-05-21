package com.interview.youtubesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class quicksort {


    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }

            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }

    public static List<Integer> quickSort(List<Integer> arr){
        // Write your code here.
        qs(arr,0,arr.size()-1);
        return arr;
    }

    public static void main(String[] args) {
         List<Integer> arr = new ArrayList<>();
         arr = Arrays.asList(4, 6, 2, 5, 7, 9, 1, 3);
         quickSort(arr);

        for (int i : arr) {

            System.out.print(i+" ");

        }

    }

}