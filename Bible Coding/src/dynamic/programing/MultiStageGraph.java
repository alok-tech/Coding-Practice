package dynamic.programing;

public class MultiStageGraph {
	
	// https://www.youtube.com/watch?v=FcScLYJI42E
	static int stages = 4, min;
	static int n = 8;
	
	static int []cost = new int[9];
	static int []d = new int[9];
	static int []path = new int[9];
	
	static int [][]c = {{0,0,0,0,0,0,0,0,0},
						{0,0,2,1,3,0,0,0,0},
						{0,0,0,0,0,2,3,0,0},
						{0,0,0,0,0,6,7,0,0},
						{0,0,0,0,0,6,8,9,0},
						{0,0,0,0,0,0,0,0,6},
						{0,0,0,0,0,0,0,0,4},
						{0,0,0,0,0,0,0,0,5},
						{0,0,0,0,0,0,0,0,0}
						};
			
	public static void main(String[] args) {
		cost[n] = 0;
		
		
		for(int i = n-1; i >= 1; i--) {
		min = 32767;
		// I will go only in the forward direction
		// Because No edge backwards
			for(int k = i+1; k <=n; k++) {
				if(c[i][k] !=0 && (c[i][k]+ cost[k]) < min) {
					min = c[i][k]+ cost[k];
					d[i] = k;
				}
			}
			cost[i] = min;
		}
		
		path[1] = 1;
		path[stages] = n;
		
		for(int i = 2; i < stages; i++) {
			path[i] = d[path[i-1]]; 
		}
		
		for(int i = 1; i<= stages; i++) {
			if(i == stages) {
				System.out.print(path[i]);
			}else {
				System.out.print(path[i]+ "---->");
			}
		}
	}

}
