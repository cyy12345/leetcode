public class code542 {
    public int[][] updateMatrix(int[][] matrix) {
        //动态规划问题  考虑分两次循环
        int[][] dist = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dist[i][j]=Integer.MAX_VALUE-10000;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    if(i>0) dist[i][j] = Math.min(dist[i][j],dist[i-1][j]+1) ;
                    if(j>0) dist[i][j] = Math.min(dist[i][j],dist[i][j-1]+1);
                }else{
                    dist[i][j]=0;
                }
            }
        }
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){
                if(matrix[i][j]!=0){
                    if(j<matrix[0].length-1) dist[i][j]=  Math.min(dist[i][j],dist[i][j+1]+1) ;
                    if(i<matrix.length-1)    dist[i][j] =  Math.min(dist[i][j],dist[i+1][j]+1) ;
                }else{
                    dist[i][j]=0;
                }
            }
        }
        return dist;
    }
}
