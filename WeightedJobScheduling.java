package com.venkat.gfg.dynprog;

import java.util.Arrays;

public class WeightedJobScheduling {
	static class Job implements Comparable<Job>{
		int start;
		int end;
		int profit;
		public Job(int start, int end , int pft) {
			this.start = start;
			this.end = end;
			this.profit = pft;
		}
		public int compareTo(Job other) {
			if (this.end < other.end)
				return (-1);
			else if ( this.end > other.end)
				return 1;
			else
				return 0;
		}
	}
	public WeightedJobScheduling() {
		// TODO Auto-generated constructor stub
	}
	public static int latestNonConflict(Job[] jobs,int i) {
		for(int j = i-1; j >= 0 ; j-- ) {
			if ( jobs[j].end <= jobs[i-1].start)
				return j;
		}
		return (-1);
	}
	public static int findMaxProfit(Job[] jobs, int n) {
		// sort the array
		Arrays.sort(jobs);
		
		// base case - if n == 1
		if ( n == 1)
			return jobs[n-1].profit;
		
		// Find profit when current job is included
		int includedPft = jobs[n-1].profit;
		int i = latestNonConflict(jobs,n);
		if (i != -1)
			includedPft += findMaxProfit(jobs, i+1);
		
		// Find profit when the job is excluded
		int excludedPft = findMaxProfit(jobs,n-1);
		
		return Math.max(includedPft, excludedPft);
	}
	public static void main(String[] args) {
		Job arr[] = {new Job(3, 10, 20), 
					 new Job(1, 2, 50),
					 new Job(6, 19, 100),
					 new Job(2, 100, 200)};
	    int n = arr.length;
	    System.out.println("The optimal profit is " + findMaxProfit(arr, n) );
	}

}
