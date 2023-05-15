package com.interview.youtubesort;

import java.util.Arrays;

public class Bubblesort {

    public void bubble(int[] arr){

        //For each step, max item will come at the last respective index
        for (int i = 0; i < arr.length ; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length-i ; j++) {

                if(arr[j]<arr[j-1]){

                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                    swapped = true;

                }

            }

            //If you did not swap for a particular value of i ,  it means the array is sorted hence stop the program

            if(!swapped){
                break;
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = {9,8,7,6,5};
        Bubblesort ans = new Bubblesort();
        ans.bubble(arr);
        System.out.println(Arrays.toString(arr));

    }

}
