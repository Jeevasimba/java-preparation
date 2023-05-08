package com.interview.youtubeheap;

// reference = https://www.studytonight.com/advanced-data-structures/implementing-heaps

public class Heap {

    private int[] items = new int[10];
    private int size;

    private void insert(int item){
        if(isFull()){
            throw new IllegalStateException();
        }
        items[size++] = item;
        bubbleUp();
    }

    private void remove(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        items[0] = items[--size];
        bubbleDown();
    }

    private int largerChildIndex(int index){
        if(!hasLeftChild(index)) return index;
        if(!hasRightChild(index)) return leftChildIndex(index);
        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index){
        if(!hasLeftChild(index)) return true;
        boolean isValid = items[index] >= leftChild(index);
        if(hasRightChild(index)){
            isValid &= items[index] >= rightChild(index);
        }
        return isValid;
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index){
        return 2*index + 1;
    }

    private int rightChildIndex(int index){
        return 2*index + 2;
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= size;
    }

    private boolean isFull(){
        return size == items.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private void bubbleUp(){
        int index = size - 1;
        while(index > 0 && items[index] > items[parent(index)]){
            swap(index,parent(index));
            index = parent(index);
        }
    }

    private void bubbleDown(){
        int index = 0;
        while(index <= size && !isValidParent(index)){
            int largerChildIndex = largerChildIndex(index);
            swap(index,largerChildIndex);
            index = largerChildIndex;
        }
    }

    private int parent(int index){
        return (index - 1)/2;
    }

    private void swap(int left,int right){
        int temp = items[left];
        items[left] = items[right];
        items[right] = temp;
    }

    private int getMax(){
        return items[0];
    }



    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(40);
        heap.insert(30);
        heap.insert(20);
        heap.insert(10);
        heap.insert(2);
        heap.insert(1);
        heap.insert(5);
        heap.remove();
        System.out.println(heap.getMax());
    }
}