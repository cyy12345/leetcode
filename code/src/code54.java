import java.util.ArrayList;
import java.util.List;

public class code54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<Integer>();
        if(matrix.length == 0) return output;
        int columns = matrix[0].length;
        int rows = matrix.length;
        boolean[][] seen = new boolean[rows][columns];
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int r=0,c=0,di=0;
        for(int i=0;i<columns*rows;i++){
            output.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r+ dr[di];
            int cc = c+ dc[di];
            if(0 <= cr && cr<rows && 0<=cc && cc<columns && !seen[cr][cc]){
                r = cr;
                c= cc;
            }else{
                di = (di+1) %4;
                r+=dr[di];
                c+=dc[di];
            }
        }
        return output;
    }
}
