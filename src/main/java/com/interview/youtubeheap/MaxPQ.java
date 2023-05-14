package com.interview.youtubeheap;

public class MaxPQ {

    //To avoid default values ... int[] has default values of 0 for each index  and can interfere with heap operations ... Integer[] has null as default values for each index  ...
    private Integer[] heap;
    private int n;

    // constructor for heap
    public MaxPQ(int capacity){
        heap = new Integer[capacity+1];
        n = 0;
    }

    public boolean isempty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    private void resize(int size){
        Integer[] temp = new Integer[size];
        for (int i = 0; i < heap.length ; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }


    // for insertion use Bottom up approach
    public void insert(int val){

        if(n==heap.length-1){
            resize(2*heap.length);
        }
        n++;
        heap[n]=val;
        swim(n);
    }

    // for insertion use Bottom-up
    public void swim(int k){

        while (k > 1 && heap[k/2] < heap[k]){

            int temp = heap[k];

            heap[k] = heap[k/2];

            heap[k/2] = temp;

            k = k/2;

        }

    }

    // for deletion use Top-down approach
    public int deleteMax(){

        int max = heap[1];
        swap(1,n);
        n--;
        sink(1);
        heap[n+1] = null;
        if(n>0 && (n==(heap.length-1))){
            resize(heap.length/2);
        }
     return max;
    }

    private void sink(int k){
        while (2*k<=n){
            int j = 2*k;
            if(j<n && heap[j]<heap[j+1] ){
                j++;
            }
            if(heap[k]>=heap[j]){
                break;
            }
            swap(k,j);
            k=j;
        }
    }

    public void swap(int a,int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void printheap(){
        for (int i = 1; i < heap.length; i++) {
            if(heap[i]==null) {
                System.out.print(" --> END");
                break;
            }
          System.out.print(heap[i]+" --> ");
        }
    }


    public static void main(String[] args) {
        MaxPQ maxheap = new MaxPQ(3);
//        System.out.println(maxheap.isempty());
//        System.out.println(maxheap.size());
        maxheap.insert(40);
        maxheap.insert(30);
        maxheap.insert(20);
        maxheap.insert(10);
        maxheap.insert(2);
        maxheap.insert(1);
        maxheap.insert(5);
        maxheap.deleteMax();
        maxheap.printheap();
    }

}