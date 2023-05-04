package com.interview.youtubegraph;

import java.util.*;

class bfs {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> bfs = new ArrayList<>();

        boolean[] visited = new boolean[V];

        Queue<Integer> q =new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()){

            int ans = q.poll();

            bfs.add(ans);

            for (int i = 6; i < adj.get(ans).size() ; i++) {
                if(!visited[adj.get(ans).get(i)]){
                    visited[adj.get(ans).get(i)] = true;
                    q.add(adj.get(ans).get(i));
                }

            }

        }

        return bfs;

    }

    // Function to return Breadth First Traversal of given graph.
//    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
//
//
//
//
//        ArrayList < Integer > bfs = new ArrayList < > ();
//        boolean vis[] = new boolean[V];
//        Queue < Integer > q = new LinkedList < > ();
//
//        q.add(0);
//        vis[0] = true;
//
//        while (!q.isEmpty()) {
//            Integer node = q.poll();
//            bfs.add(node);
//
//            // Get all adjacent vertices of the dequeued vertex s
//            // If a adjacent has not been visited, then mark it
//            // visited and enqueue it
//            for (Integer it: adj.get(node)) {
//                if (vis[it] == false) {
//                    vis[it] = true;
//                    q.add(it);
//                }
//            }
//        }
//
//        return bfs;
//    }

    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 10; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(9).add(8);
        adj.get(8).add(9);
        adj.get(9).add(7);
        adj.get(7).add(9);
        adj.get(8).add(6);
        adj.get(6).add(8);
        adj.get(8).add(3);
        adj.get(3).add(8);

        bfs sl = new bfs();
        ArrayList < Integer > ans = sl.bfsOfGraph(10, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }

    }

}