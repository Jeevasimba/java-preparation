package com.interview.demo;

//import java.util.ArrayList;
//
//class Solution {
//
//    public int[][] merge(int[][] intervals) {
//
//        ArrayList<ArrayList<Integer>> af = new ArrayList<>();
//
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        ans.add(intervals[0][0]);
//
//        ans.add(intervals[0][1]);
//
//        af.add(ans);
//
//        for (int i = 1; i < intervals.length ; i++) {
//
//            range(intervals[i][0],intervals[i][1],af);
//
//        }
//
//        int[][] arr = new int[af.size()][af.get(0).size()];
//
//
//        return af.toArray(arr);
//    }
//
//    public void range(int start,int end,ArrayList<ArrayList<Integer>> node){
//
//        for (ArrayList<Integer> item: node) {
//
//            if(start<= item.get(1)){
//
//                if(start<item.get(0)){
//                    item.set(0,start);
//                }
//
//                if(end>item.get(1)){
//                    item.set(1,end);
//                }
//
//                return;
//
//            }
//
//        }
//
//
//        ArrayList<Integer> after = new ArrayList<>();
//        after.add(start);
//        after.add(end);
//        node.add(after);
//
//
//    }
//
//    public static void main(String[] args) {
//
//        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
//
//        Solution a = new Solution();
//
//       int[][] s=  a.merge(arr);
//
//        System.out.println();
//
//    }
//
//}

//import java.util.Arrays;
//
//class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//
//        int i = 0;
//        int j = 0;
//
//        int temp = 0;
//
//        while (i<nums1.length && j<nums2.length){
//
//            if(temp<nums1[i] && temp!=0){
//                int tempb = nums1[i];
//                nums1[i] = temp;
//                temp = tempb;
//                i++;
//                continue;
//            }
//            if(nums1[i]<nums2[j] && nums1[i]!=0){
//                i++;
//            } else if (nums1[i]<nums2[j] && nums1[i]==0) {
//                nums1[i] = nums2[j];
//                j++;
//            } else if(nums1[i]>nums2[j]){
//                temp = nums1[i];
//                nums1[i] = nums2[j];
//                j++;
//                i++;
//            }else {
//                i++;
//            }
//
//        }
//
//        System.out.println(Arrays.toString(nums1));
//    }
//
//
//    public static void main(String[] args) {
//        Solution ans = new Solution();
//
//        int[] nums1 = {4,5,6,0,0,0};
//        int[] nums2 = {1,2,3};
//
//        ans.merge(nums1,3,nums2,3);
//
//    }
//
//}


import java.util.*;

class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here

        int[] ans = new int[2];

        Collections.sort(arr);

        Set<Integer> unique = new HashSet<>();

        for (int i = 1; i < arr.size(); i++) {

            if(i != arr.get(i-1)){
                ans[0] = i;
            }

            if(unique.contains(arr.get(i-1))){
                ans[1] = i-1;
            }else {
                unique.add(i-1);
            }

            if(unique.contains(ans[0]) && ans[0]!=0){
                ans[0] = 0;
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(3);
        arr.add(2);
        arr.add(1);

        System.out.println(Arrays.toString(missingAndRepeating(arr,4)));

    }

}