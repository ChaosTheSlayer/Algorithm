package Algorithm.Other;

//Question:https://leetcode.com/problems/unique-paths/

public class UniquePaths{

	//There are two ways to solve this, first DFS, second using dynamic programming


	//first using dfs, although seems like it can not passed by leetcode due to TLE
	//but I think it's still a O(n*m) solution, using DFS and DP 
	//we only do one dfs, 
	    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public  static int uniquePaths(int m,int n){
		if(m <=0 || n<=0){
			return 0;
		}
		HashMap<Point,Integer> map = new HashMap<Point,Integer>();
		return helper(1,1,m,n,map);
	}

	private static int helper(int curM,int curN, int m,int n,Map<Point,Integer> map){
		if(curM > m || curN > n){
			return 0;
		}
		if(curM == m && curN == n){
		    map.put(new Point(m,n),1);
			return 1;
		}
		Point curPoint = new Point(curM,curN);
		if(map.containsKey(curPoint)){
		    return map.get(curPoint);
		}
	    Point downPoint = new Point(curM+1,curN);
	    Point rightPoint = new Point(curM,curN+1);
	    
		int down = map.containsKey(downPoint)?map.get(downPoint) :helper(curM+1,curN,m,n,map);
		int right = map.containsKey(rightPoint)? map.get(rightPoint):helper(curM,curN+1,m,n,map);
		map.put(curPoint,down+right);
		return down+right;
	}

	public int uniquePaths(int m, int n) {
        if(m <=0 || n <=0){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int j = 0;j<n;j++){
            dp[0][j] =1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    //Still be able to improve
    //because we know the dp function is dp[i][j] = dp[i-1][j] + dp[i][j-1];
    //means that we only need the result of previous row same column
    //and same row previous column
     public int uniquePaths(int m,int n){
    	if(m <= 0 || n <=0){
    		return 0;
    	}
    	int[] res = new int[n];
    	res[0] = 1;
    	for(int i = 0;i<m;i++){
    		for(int j = 1;j<n;j++){
    			//res[j] means the result of previous row
    			//res[j-1] is the result or same row previous column
    			res[j] += res[j-1];
    		}
    	}
    	return res[n-1];
    }

}