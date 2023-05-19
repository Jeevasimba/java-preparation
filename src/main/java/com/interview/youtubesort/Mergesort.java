package com.interview.youtubesort;

import java.util.Arrays;

public class Mergesort {

    public int[] mergest(int[] arr){

        if(arr.length==1){
            return arr;
        }

        int mid = arr.length/2;

        int[] left = mergest(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergest(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);

    }

    private int[] merge(int[] left, int[] right) {

        int[] mix = new int[left.length+right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i<left.length && j<right.length){

            if(left[i]<right[j]){
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        while (i<left.length){
            mix[k] = left[i];
            i++;
            k++;
        }

        while (j<right.length){

            mix[k] = right[j];
            j++;
            k++;

        }

        return mix;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,7,9,2};
        Mergesort ans = new Mergesort();
        System.out.println(Arrays.toString(ans.mergest(arr)));
    }

}