package com.interview.youtubegraph;

// Java implementation of the approach
import java.util.*;

public class  BFSAdjacencyMatrix{

   static  class Graph{


       int Node;

       int Edge;

       int adj[][];

       Graph(int N,int E){
           adj = new int[N][N];
           for (int[] ints : adj) {
               Arrays.fill(ints, 0);
           }
           Node = N;
           Edge = E;
       }

       void addEdge(int i,int j){

           adj[i][j] = 1;
           adj[j][i] = 1;

       }

       void BFS(int start){

           boolean[] visited = new boolean[Node];

           Queue<Integer> q = new LinkedList<>();

           q.add(start);
           visited[start] = true;

           while (!q.isEmpty()){

               int ans = q.poll();

               System.out.print(ans+" ");

               for (int i = 0; i < Node ; i++) {
                   if(adj[ans][i]==1 && (!visited[i])){

                       q.add(i);

                       visited[i] = true;

                   }
               }

           }


       }






   }

    // Driver code
    public static void main(String[] args)
    {

        int v = 4, e = 3;

        // Create the graph
        Graph G = new Graph(v, e);
        G.addEdge(0, 0);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);

        G.BFS(0);
    }
}

// This code is contributed by sanjeev2552
