package com.interview.youtubetree;

import java.util.Stack;

public class Inorder {


    public static void inorder(Node node){

        Stack<Node> stack = new Stack<>();

        while (true){

            if(node!=null){
                stack.push(node);
                node = node.left;
            }else {
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();

                System.out.println(node.data);

                node = node.right;

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

        inorder(root);

    }

}