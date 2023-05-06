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

//    Deletion scenarios :
//
//    Leaf node :
//
//    mark the parent point null (Left or Right)
//
//
//    Node with one child:
//    Link that one child to the parent
//
//    Node with two children:
//
//    Replace the node to be deleted with its
//    inorder successor. then delete that inorder
//    successor from its right subtree.
//
//    inorder successor - means current node's next node in inorder
//
//    eg : 55 , 60,70,75, 80
//
//            75 is inorder successor
//
//    inorder predecessor - means current node's previous node in inorder
//
//    eg : 55 , 60,70,75, 80
//
//            60 - inorder predecessor




    void deleteKey(int key) {
        root = deleteRec(root, key);
    }


    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }



    public Node search(Node root,int val){

        if(root==null||root.key==val){
            return root;
        }

        if(val< root.key)
            return search(root.left,val);

        return search(root.right,val);
    }

    public void preorder(Node node){

        if(node!=null){

            System.out.print(node.key);
            preorder(node.left);
            preorder(node.right);

        }

    }

    public void postorder(Node node){

        if(node!=null){

            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key);

        }

    }

    public void inOrder(Node node){

        if(node!=null){

            inOrder(node.left);
            System.out.print(node.key);
            inOrder(node.right);

        }

    }


    public static void main(String[] args) {
        BST ans = new BST(1);
        ans.insert(0);
        ans.insert(2);
        System.out.println("preorder");
        ans.preorder(ans.root);
        ans.deleteKey(2);
        System.out.println("\n After deleting");
        ans.preorder(ans.root);
//        System.out.println("\ninorder");
//        ans.inOrder(ans.root);
//        System.out.println("\npostorder");
//        ans.postorder(ans.root);
    }


}