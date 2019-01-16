package Other;

public class SudokuSolver{
    public static void solveSudoku(char[][] board){
		//corner cases
		if(board == null || board.length != 9 || board[0].length !=9){
			return ;
		}

		//So the basica idea is that try to put different digit in to the space
		//and say if current board is valid, if it is, keep doing that
		helper(board,0,0);

	}

	//here we should have a return value, to indicate we found a valid solution
	//other wise it will keep tring new solution
	private static boolean helper(char[][] board, int i, int j){
		if(j>=9){
			 return helper( board,i+1,0);
		}
		if(i==9){
			return true;
		}
		if(board[i][j] != '.'){
			return helper(board,i,j+1);
		}else{
			for(int digit = 1;digit <=9;digit++){
				
				board[i][j] = (char) (digit+'0');
				if(isValid(board,i,j)){
					if(helper(board,i,j+1)){
						return true;
					}
				}
				board[i][j] = '.';
			}
		}
		//no valid solution
		return false;
		
	}

	private static boolean isValid(char[][] board,int i,int j){
		//Since the previous board should be valid, so we only need to check 
		//if there is conflict between new added elment and previous board

		for(int k = 0 ;k<9;k++){
			if(k != i && board[k][j] == board[i][j]){
				return false;
			}
		}
		for(int k = 0;k<9;k++){
			if(k!= j && board[i][k] == board[i][j]){
				return false;
			}
		}
		for(int row = i/3*3;row<i/3*3+3;row++){
			for(int col = j/3*3;col < j/3*3+3;col++){
				if((i != row && j != col) && board[i][j] == board[row][col]){
					return false;
				}
			}
		}
		return true;
	}
}