package com.interview.youtubesort;

import java.util.Arrays;

public class Selectionsort {

    public void selection(int[] arr){

        for (int i = 0; i < arr.length ; i++) {

            int last = arr.length - i -1;

            int maxIndex =  getMaxIndexarr(arr,0,last);

            swap(arr,maxIndex,last);

        }

    }

    private int getMaxIndexarr(int[] arr,int start,int last) {

        int max = start;

        for (int i = start; i <= last ; i++) {

            if(arr[max] < arr[i]){
                max = i;
            }

        }

     return max;
    }

    public void swap(int[] arr,int first, int second){

        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }

    public static void main(String[] args) {

        int[] arr = {9,8,7,6,5};
        Selectionsort ans = new Selectionsort();
        ans.selection(arr);
        System.out.println(Arrays.toString(arr));

    }

}