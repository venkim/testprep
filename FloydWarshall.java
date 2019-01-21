package com.venkat.gfg.dynprog;

public class FloydWarshall {

	final static int INF = 99999, V = 4;
	public FloydWarshall() {
		// TODO Auto-generated constructor stub
	}
	 
    void printSolution(int dist[][])
    {
        System.out.println("Following matrix shows the shortest "+
                         "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public void floydWarshall(int[][] dist) {
    	// k - stands for intermediate vertices
    	// intermediate vertices must be ascending and must
    	// be of known cost to be able to help calc other costs.
    	for(int k = 0 ; k < V;k++) {
    		// i - stands for source vertices
    		for(int i = 0 ; i < V;i++) {
    			// j - stands for destination vertices
    			for(int j = 0 ; j < V;j++) {
    				// using k as an intermediate vertex - reduces cost
    				if ( dist[i][k] + dist[k][j] < dist[i][j]) {
    					dist[i][j] = dist[i][k] + dist[k][j];
    				}
    			}
    		}
    	}
    	printSolution(dist);
    }
	public static void main (String[] args){
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INF, 10},
                          {INF, 0,   3, INF},
                          {INF, INF, 0,   1},
                          {INF, INF, INF, 0}
                        };
        

        // All paths shortest path - apsp
        FloydWarshall apsp = new FloydWarshall();
        System.out.println("Printing dist before floyd warshall");
        apsp.printSolution(graph);
 
        // Print the solution
        apsp.floydWarshall(graph);
    }

}
