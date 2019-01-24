package com.venkat.leetfree;

public class NumConnComp {
	int n;
	int[][] edges;
	int[] parent;
	int numConn = 0;
	public NumConnComp(int n, int[][] edges) {
		this.n= n;
		this.edges = edges;
		numConn = 0;
		parent = new int[n];
		for(int i = 0 ; i < n; i++)
			parent[i] =i;
		findComp();
	}
	public int getConnNum() {
		return numConn;
	}
	private void findComp() {
		numConn = 0;
		for(int[] edge: edges) {
			int u = edge[0];
			int v = edge[1];
			int paru = getParent(u);
			int parv = getParent(v);
			if (paru == parv)
				return;
			parent[paru] = parv;
		}
		numConn = 0;
		for(int i = 0 ; i < n; i++) {
			if (parent[i] == i) {
				numConn++;
			}
		}
	}
	public int getParent(int i) {
		while (i != parent[i]) {
			i = parent[i];
		}
		return (parent[i]);
	}
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4} };
		NumConnComp ncc = new NumConnComp(n,edges);
		System.out.println("Num conn1 = " + ncc.getConnNum());

		int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
		ncc = new NumConnComp(n,edges2);
		System.out.println("Num conn2 = " + ncc.getConnNum());
	}

}
