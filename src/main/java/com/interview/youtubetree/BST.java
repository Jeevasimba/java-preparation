package com.interview.youtubetree;

class Node{

    int key;

    Node left,right;

    Node(int val){
        key = val;
        left =  right = null;
    }

}

public class BST {

    Node root;

    public BST(int val){
        root = new Node(val);
    }

    public BST(){
        root = null;
    }


    public void insert(int val){

        insert(root,val);

    }

    public Node insert(Node root , int val){

        if(root==null)
            return new Node(val);

        if(val< root.key)
            root.left = insert(root.left,val);
        else
            root.right = insert(root.right,val);


      return root;
    }

    public Node search(Node root,int val){

        if(root==null||root.key==val){
            return root;
        }

        if(val< root.key)
            return search(root.left,val);

        return search(root.right,val);
    }

    public void inOrder(Node node){

        if(node!=null){

            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);

        }

    }


    public static void main(String[] args) {
        BST ans = new BST(1);
        ans.insert(0);
        ans.insert(2);
        ans.inOrder(ans.root);
    }


}
