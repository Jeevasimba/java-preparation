package com.interview.youtubetree;

import static java.lang.Math.max;

public class AVL {

    class Node{

        int key;

        Node left,right;

        int height;

        Node(int val){
            key = val;
            left =  right = null;
            height = 0;
        }

    }

    Node root;

    public AVL(int val){
        root = new Node(val);
    }

    public int getHeight(Node node){

        if(node==null){
            return -1;
        }

        return node.height;

    }

    public int getBalancedfactor(Node node){
        if(node==null){
           return 0;
        }

        return getHeight(node.left)-getHeight(node.right);

    }

// rotation image explanation = https://raw.githubusercontent.com/Jeevasimba/files/main/prog%20img/8.PNG

    public Node leftRotate(Node z){

        Node y = z.right;
        Node t3 = y.left;

        y.left = z;
        z.right = t3;

        z.height = 1+max(getHeight(z.left),getHeight(z.right));
        y.height = 1+max(getHeight(y.left),getHeight(y.right));

        return y;
    }

    public Node rightRotate(Node z){

        Node y = z.left;
        Node t3 = y.right;

        y.right = z;
        z.left = t3;

        z.height = 1+max(getHeight(z.left),getHeight(z.right));
        y.height = 1+max(getHeight(y.left),getHeight(y.right));


        return y;
    }

    public void insert(int val){

        insert(root,val);

    }

    public Node insert(Node node , int val){

        if(node==null)
            return new Node(val);

        if(val< node.key)
            node.left = insert(node.left,val);
        else if (val > node.key)
            node.right = insert(node.right,val);
        else
            return node;

        node.height = 1+max(getHeight(node.right),getHeight(node.left));

        int balancefactor = getBalancedfactor(node);

        //LL Case
        if(balancefactor>1 && val<node.left.key){
           return leftRotate(node);
        }
        //LR Case
        if(balancefactor>1 && val>node.left.key){
            node.left = leftRotate(node);
            return rightRotate(node);
        }
        //RR Case
        if(balancefactor<-1&&val>node.right.key){
            return rightRotate(node);
        }
        //RL Case
        if(balancefactor<-1&&val<node.right.key){
            node.right = rightRotate(node);
            return leftRotate(node);
        }

        return node;
    }

    public void inOrder(Node node){

        if(node!=null){

            inOrder(node.left);
            System.out.println(node.key + " height is "+ node.height);
            inOrder(node.right);

        }

    }

    public static void main(String[] args) {

        AVL tree = new AVL(50);
        tree.insert(20);
        tree.insert(60);
        tree.insert(10);
        tree.insert(30);
        tree.insert(40);
        tree.inOrder(tree.root);

    }

}