public class code240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 ||matrix[0].length==0 || matrix==null) return false;
        int R = matrix.length;
        int C = matrix[0].length;
        if(target>matrix[R-1][C-1] || target<matrix[0][0]){
            return false;
        }
        for(int i=0;i<R;i++){
            for(int j=C-1;j>=0;j--){
                if(target>matrix[i][j]){
                    break;
                }
                if(target==matrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
