package com.interview.youtubegraph;

import java.util.*;

class DFS {

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean[] visited = new boolean[V+1];

        ArrayList<Integer> ans = new ArrayList<>();

        visited[0] = true;

        dfs(0,adj,ans,visited);

      return ans;
    }

    public void dfs(int node , ArrayList<ArrayList<Integer>> adj ,ArrayList<Integer> ans, boolean[] visited){

        visited[node] = true;

        ans.add(node);

        for (int i : adj.get(node) ) {
            if(!visited[i]) {
                dfs(i, adj, ans, visited);
            }
        }

    }

    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        DFS sl = new DFS();
        ArrayList < Integer > ans = sl.dfsOfGraph(5, adj);
        int n = ans.size();
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
}