public class code289 {
    public void gameOfLife(int[][] board) {

        int R = board.length;
        int C = board[0].length;
        if((R<2) || (C<2)){
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    board[i][j]=0;
                }
            }
            return;
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int lifecount = 0;
                if(i==0 && j==0){
                    if(board[i+1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j+1]>0){
                        lifecount+=1;
                    }
                }
                else if(i==0 && j==C-1){
                    if(board[i+1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j-1]>0){
                        lifecount+=1;
                    }
                    if(board[i][j-1]>0){
                        lifecount+=1;
                    }
                }
                else if(i==R-1 && j==C-1){
                    if(board[i-1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j-1]>0){
                        lifecount+=1;
                    }
                    if(board[i][j-1]>0){
                        lifecount+=1;
                    }
                }
                else if(i==R-1 && j==0){
                    if(board[i][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j+1]>0){
                        lifecount+=1;
                    }
                }
                else if(i==0 && j>0 && j< C-1  )
                {
                    if(board[i+1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j-1]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i][j-1]>0){
                        lifecount+=1;
                    }
                }
                else if(i==R-1 && j>0 && j< C-1 )
                {
                    if(board[i-1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j-1]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i][j-1]>0){
                        lifecount+=1;
                    }
                }
                else if(j==0 && i>0 && i< R-1  )
                {
                    if(board[i-1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j+1]>0){
                        lifecount+=1;
                    }
                }
                else if(j==C-1 && i>0 && i< R-1  )
                {
                    if(board[i-1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j-1]>0){
                        lifecount+=1;
                    }
                    if(board[i][j-1]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j-1]>0){
                        lifecount+=1;
                    }
                }else{

                    if(board[i][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i][j-1]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j]>0){
                        lifecount+=1;
                    }
                    if(board[i+1][j-1]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j+1]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j-1]>0){
                        lifecount+=1;
                    }
                    if(board[i-1][j]>0){
                        lifecount+=1;
                    }
                }

                if((lifecount==2 || lifecount==3) && board[i][j]==1){
                    board[i][j]=2;
                }
                if(lifecount==3 && board[i][j]==0){
                    board[i][j]=-1;
                }
                if((lifecount<2 || lifecount>3) && board[i][j]==1){
                    board[i][j]=3;
                }


            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j]==-1 || board[i][j]==2){
                    board[i][j]=1;
                }
                if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
    //discuss 中使用的这个判断方法，更加方便，不需要做这么多判断
    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
