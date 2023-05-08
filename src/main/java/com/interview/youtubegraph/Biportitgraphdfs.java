package com.interview.youtubegraph;

import java.util.ArrayList;
import java.util.Arrays;

public class Biportitgraphdfs {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] vis = new int[V];

        Arrays.fill(vis,-1);

        for (int i = 0; i < V ; i++) {

            if(vis[i]==-1){
                vis[i] = 0;
                if(!dfs(adj,vis,i)){
                    return false;
                }
            }

        }

        // Code here
        return true;

    }

    public boolean dfs(ArrayList<ArrayList<Integer>>adj,int[] vis,int node){

        int preval = vis[node];

        for (int item: adj.get(node)) {

            if(vis[item]==-1){

                vis[item] = 1 - preval;

                dfs(adj,vis,item);
            } else if (preval==vis[item]) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args)
    {
        // V = 4, E = 4
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }

        adj.get(4).add(4);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(3);

        Biportitgraphdfs obj = new Biportitgraphdfs();
        boolean ans = obj.isBipartite(5, adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

}