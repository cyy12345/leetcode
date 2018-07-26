import java.util.HashMap;
import java.util.Map;

public class code454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res=0;
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
            }
        }

        return res;
    }
}
