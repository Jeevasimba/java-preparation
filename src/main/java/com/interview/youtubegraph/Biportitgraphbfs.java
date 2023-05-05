package com.interview.youtubegraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Biportitgraphbfs {


    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {

        int[] vis = new int[V];

        Arrays.fill(vis,-1);

        for (int i = 0; i < V ; i++) {

            if(vis[i]==-1){
                 if(bfs(V,adj,vis,i)){
                     return true;
                 }
            }

        }

        // Code here
        return false;
    }


    public boolean bfs(int V, ArrayList<ArrayList<Integer>>adj,int[] vis,int node){

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 0;

        while (!q.isEmpty()){
            Integer element = q.poll();

            int preval = vis[element];

            for (Integer item : adj.get(element)) {

                q.add(item);

                if(vis[item]==-1){
                    if(preval==0){
                        vis[item] = 1;
                    }else {
                        vis[item] = 0;
                    }
                } else if (preval==vis[item]) {
                    return false;
                }

            }

        }

        return true;
    }


    public static void main(String[] args)
    {
        // V = 4, E = 4
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        Biportitgraphbfs obj = new Biportitgraphbfs();
        boolean ans = obj.isBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }

}

// this is for code ninja

//package com.interview.youtubegraph;
//
//        import java.util.ArrayList;
//        import java.util.Arrays;
//        import java.util.LinkedList;
//        import java.util.Queue;
//
//public class Biportitgraphbfs {
//
//    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
//
//        int[] vis = new int[edges.size()];
//
//        Arrays.fill(vis,-1);
//
//        for (int i = 0; i < edges.size() ; i++) {
//
//            if(vis[i]==-1){
//                if(bfs(edges,vis,i)){
//                    return true;
//                }
//            }
//
//        }
//
//        // Code here
//        return false;
//    }
//
//
//
//    public static boolean bfs(ArrayList<ArrayList<Integer>>adj,int[] vis,int node){
//
//        Queue<Integer> q = new LinkedList<>();
//        q.add(node);
//        vis[node] = 0;
//
//        while (!q.isEmpty()){
//            Integer element = q.poll();
//
//            int preval = vis[element];
//
//            for (Integer item : adj.get(element)) {
//
//                q.add(item);
//
//                if(vis[item]==-1){
//                    if(preval==0){
//                        vis[item] = 1;
//                    }else {
//                        vis[item] = 0;
//                    }
//                } else if (preval==vis[item]) {
//                    return false;
//                }
//
//            }
//
//        }
//
//        return true;
//    }
//
//
//    public static void main(String[] args)
//    {
//        // V = 4, E = 4
//        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
//        for (int i = 0; i < 4; i++) {
//            adj.add(new ArrayList < > ());
//        }
//        adj.get(0).add(2);
//        adj.get(2).add(0);
//        adj.get(0).add(3);
//        adj.get(3).add(0);
//        adj.get(1).add(3);
//        adj.get(3).add(1);
//        adj.get(2).add(3);
//        adj.get(3).add(2);
//
//
//        boolean ans = isGraphBirpatite( adj);
//        if(ans)
//            System.out.println("1");
//        else System.out.println("0");
//    }
//
//}