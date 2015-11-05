package Algorithm.String;

public class WordSearch{

	 public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        if(word.length() == 0){
            return false;
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                
                if(helper(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board,int i,int j, String word,int index){
        if(index == word.length()){
            return true;
        }
        if(i<0 || j<0 || i >= board.length || j >= board[0].length|| board[i][j] != word.charAt(index) || board[i][j] == '0'){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '0';
        boolean res = helper(board,i-1,j,word,index+1) || helper(board,i+1,j,word,index+1) || helper(board,i,j-1,word,index+1) || helper(board,i,j+1,word,index+1);
        board[i][j] = temp;
        return res;
    }
}