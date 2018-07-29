import java.util.HashSet;
import java.util.Set;

public class code753 {
    Set<String> seen;
    StringBuilder ans;

    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";
        seen = new HashSet();
        ans = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; ++i)
            sb.append("0");
        String start = sb.toString();

        dfs(start, k);
        ans.append(start); //这个apend放在dfs之后  生成的字符串是反向的
        return new String(ans);
    }

    public void dfs(String node, int k) {
        for (int x = 0; x < k; ++x) {
            String nei = node + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei.substring(1), k);
                ans.append(x); 
                //记录下stuck的那个node，因为stuck了，要么所有出路都访问完了，要么有没访问完的，exit出来
                // 后继续访问
            }
        }
    }
}
