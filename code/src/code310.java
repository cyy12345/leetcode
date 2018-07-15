import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] distances = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distances[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;i++){
            distances[edges[i][0]][edges[i][1]]=1;
            distances[edges[i][1]][edges[i][0]]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(distances[i][j]<Integer.MAX_VALUE){
                    for(int k=0;k<n;k++){
                        if(distances[j][k]!=0 && k!=i && distances[j][k]>distances[i][j]+distances[j][k]){

                            distances[i][k]=distances[i][j]+distances[j][k];
                        }
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distances[j][i]=distances[i][j];
            }
        }
        int[] max = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j!=i){
                    if(distances[i][j]>max[i]){
                        max[i]=distances[i][j];
                    }
                }
            }
        }
        LinkedList<Integer> root=new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(max[i]<=min){
                min= max[i];
            }
        }
        for (int i=0;i<n;i++){
            if(max[i]==min){
                root.add(i);
            }
        }
        return root;

    }
}