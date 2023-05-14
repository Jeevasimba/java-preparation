package com.interview.youtubetree;

import java.util.Stack;

public class Postorder {

    public static void post(Node node){

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.add(node);

        while (!s1.isEmpty()){
            node = s1.pop();
            s2.add(node);
            if(node.left!=null){

                s1.add(node.left);

            }

            if(node.right!=null){

                s1.add(node.right);

            }

        }

        while (!s2.isEmpty()){
            System.out.print(s2.pop().data);
        }

    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        post(root);

    }

}
