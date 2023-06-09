package com.interview.youtubetree;

import java.util.Stack;

public class Preorder {

    public static void pre(Node node){

        Stack<Node> stack = new Stack<>();

        if(node!=null){
            stack.push(node);
        }

        while (!stack.isEmpty()){

            Node temp = stack.pop();

            System.out.println(temp.data);

            if(temp.right!=null){
                stack.push(temp.right);
            }

            if(temp.left!=null){
                stack.push(temp.left);
            }
        }

    }


    public static void main(String args[]) {

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

        pre(root);

    }


}
