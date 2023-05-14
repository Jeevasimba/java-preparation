package com.interview.youtubetree;

import org.checkerframework.checker.units.qual.C;

public class Checkbalancedtree {

    public boolean isBalanced(Node root){

       int check = dfs(root);

        return check != -1;
    }

    public int dfs(Node root){

        if(root==null)
            return 0;

        int leftheight = dfs(root.left);
        if(leftheight==-1)
            return -1;
        int rightheight = dfs(root.right);
        if(rightheight==-1)
            return -1;

        if(Math.abs(leftheight-rightheight)>1)
            return -1;

        return Math.max(leftheight,rightheight) + 1;

    }



    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        root.right.right.right.right = new Node(11);
        root.right.right.right.right.right = new Node(12);


        Checkbalancedtree ans = new Checkbalancedtree();

        System.out.println(ans.isBalanced(root));


    }

}