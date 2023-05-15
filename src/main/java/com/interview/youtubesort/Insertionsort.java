package com.interview.youtubesort;

import java.util.Arrays;

public class Insertionsort {

    public void insertion(int[] arr){

        for (int i = 0; i < arr.length - 1 ; i++) {

            for (int j = i+1; j > 0 ; j--) {

                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                } else {
                    break;
                }

            }

        }

    }

    public void swap(int[] arr,int first, int second){

        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }

    public static void main(String[] args) {

        int[] arr = {9,5,3,7,1};
        Insertionsort ans = new Insertionsort();
        ans.insertion(arr);
        System.out.println(Arrays.toString(arr));

    }

}
