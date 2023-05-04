package com.interview.codingplatforms;

import java.util.*;

class Node{

    int source;

    int parent;

    public Node(int source,int parent){

        this.source = source;

        this.parent = parent;

    }

}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V ; i++) {
             if(!vis[i]) {
                    if(bfs(adj,i,vis)){
                        return true;
                    }
             }
        }

     return false;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int start , boolean[] vis){

        vis[start] = true;

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(start,-1));

        while (!q.isEmpty()){
            
            int source = q.peek().source;
            
            int parent = q.peek().parent;

            q.remove();

            for (int i = 0; i < adj.get(source).size(); i++) {
                
                if(!vis[adj.get(source).get(i)]){
                    q.add(new Node(adj.get(source).get(i),source));
                    vis[adj.get(source).get(i)] = true;
                } else if (parent!=adj.get(source).get(i)) {
                    return true;
                }

            }
            
            
        }


        return false;
    }

//    public static void main(String[] args) {
//        int V = 4;
//
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//
//        for (int i = 0; i < V ; i++) {
//            adj.add(new ArrayList<>());
//        }
//
//        adj.get(1).add(2);
//        adj.get(2).add(1);
//        adj.get(2).add(3);
//        adj.get(3).add(2);
//        adj.get(3).add(1);
//        adj.get(1).add(3);
//        Solution a = new Solution();
//
//        String ans = a.isCycle(V,adj) ? "this is a cycle" : "this is not a cycle";
//
//        System.out.println(ans);
//
//    }

}