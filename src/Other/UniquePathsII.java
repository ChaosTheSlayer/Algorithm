package Other;

public class UniquePathsII{

	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        int i = 1;
        while(i<m){
            if(obstacleGrid[i][0] == 1){
                break;
            }else{
                dp[i][0] = 1;
            }
            i++;
        }
        if(i<m){
            for(;i<m;i++){
                dp[i][0] = 0;
            }
        }
          int j = 1;
        while(j<n){
            if(obstacleGrid[0][j] == 1){
                break;
            }else{
                dp[0][j] = 1;
            }
            j++;
        }
        if(j<n){
            for(;j<n;j++){
                dp[0][j] = 0;
            }
        }
        for( i = 1;i<m;i++){
            for(j = 1;j<n;j++){
                dp[i][j] = obstacleGrid[i][j] == 1? 0:(dp[i-1][j]+dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid == null || obstacleGrid.length==0 || obstacleGrid[0].length==0)
       	 return 0;
    	int[] res = new int[obstacleGrid[0].length];
    	res[0] = 1;
   		 for(int i=0;i<obstacleGrid.length;i++)
   	    {
        for(int j=0;j<obstacleGrid[0].length;j++)
        {
            if(obstacleGrid[i][j]==1)
            {
                res[j]=0;
            }
            else
            {
                if(j>0)
                    res[j] += res[j-1];
            }
        }
    }
    return res[obstacleGrid[0].length-1];
}
}