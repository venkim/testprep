package com.venkat.leetfree;

public class RangeSumMutable {
	int[][] mat;
	int[][] aux;
	public RangeSumMutable(int[][] mat) {
		this.mat = mat;
		aux = new int[mat.length][mat[0].length];
		buildAux();
	}
	private void buildAux() {
		// initialize aux -- first top columnn
		for(int j = 0 ; j < mat[0].length; j++) 
			aux[0][j] = mat[0][j];
		// column wise sum
		for(int i = 1 ; i < mat.length;i++) {
			for(int j = 0; j < mat[i].length; j++) {
				aux[i][j] = aux[i-1][j] + mat[i][j];
			}
		}
		// row wise sum
		for(int i = 0; i < mat.length ;i++) {
			for(int j = 1 ; j < mat[i].length; j++) {
				aux[i][j] += aux[i][j-1];
			}
		}		
	}
	public int sumQuery(int tli, int tlj, int rbi, int rbj) {
		int temp = aux[rbi][rbj];
		if (tli > 0)
			temp -= aux[tli-1][rbj];
		
		if (tlj > 0)
			temp -= aux[rbi][tlj-1]; 
		
		if (tli > 0 && tlj > 0)			
			temp += aux[tli-1][tlj-1];
		
		return (temp);
	}
	public void update(int r, int c, int val) {
		int diff = val - mat[r][c];
		mat[r][c] = val;
		for(int i = r; i < mat.length; i++) {
			for(int j = c; j < mat[i].length; j++) {
				aux[i][j] += diff;
			}
		}
	}
	public static void main(String[] args) {
		int[][] mat =  {
				{1, 2, 3, 4, 6}, 
                {5, 3, 8, 1, 2}, 
                {4, 6, 7, 5, 5}, 
                {2, 4, 8, 9, 4} 
                }; 
		RangeSumMutable rsm = new RangeSumMutable(mat);
		int tli = 2, tlj = 2, rbi = 3, rbj = 4; 
        System.out.print("\nQuery1: "
            + rsm.sumQuery(tli, tlj, rbi, rbj)); 
          
        tli = 0; tlj = 0; rbi = 1; rbj = 1; 
        System.out.print("\nQuery2: "
            + rsm.sumQuery(tli, tlj, rbi, rbj)); 
          
        tli = 1; tlj = 2; rbi = 3; rbj = 3; 
        System.out.print("\nQuery3: " 
            + rsm.sumQuery(tli, tlj, rbi, rbj)); 
		
        rsm.update(2, 3, 15);
        
        tli = 1; tlj = 2; rbi = 3; rbj = 3; 
        System.out.print("\nQuery3: " 
            + rsm.sumQuery(tli, tlj, rbi, rbj)); 
		
	}

}
