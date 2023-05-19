package com.interview.youtubeheap;

import java.util.Arrays;

public class Heapify {

    public static void main(String[] args) {

        int[] arr = {16,7,22,3,19,9,33};

        Heapify demo = new Heapify();

        demo.sort(arr,arr.length);

        System.out.println(Arrays.toString(arr));

    }

    public void sort(int[] arr,int size) {

        for(int i= size/2-1;i>=0;i--) {

            heapify(arr,size,i);

        }

        for(int i=size-1;i>=0;i--) {

            int temp = arr[0];

            arr[0] = arr[i];

            arr[i] = temp;

            heapify(arr,i,0);

        }

    }

    public void heapify(int[] arr,int size,int i) {

        int largest = i;

        int left = (2*i)+1;
        int right = (2*i)+2;

        if(left<size && arr[left]> arr[largest]) {

            largest = left;

        }

        if(right<size && arr[right]> arr[largest]) {

            largest = right;

        }

        if(largest!= i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr,size,largest);

        }

    }

}