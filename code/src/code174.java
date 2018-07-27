public class code174 {
    /*
    The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.



Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)


Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int R = dungeon.length;
        int C = dungeon[0].length;
        int[][] hp = new int[R][C];
        hp[R-1][C-1] = Math.max(1-dungeon[R-1][C-1],1);
        for(int i=R-2;i>=0;i--){  //先将右边和下边的最小生命值要求计算出来，再根据这个遍历所有情况
            hp[i][C-1] = Math.max(hp[i+1][C-1]-dungeon[i][C-1],1);
        }
        for(int i=C-2;i>=0;i--){
            hp[R-1][i] = Math.max(hp[R-1][i+1]-dungeon[R-1][i],1);
        }
        for(int i=R-2;i>=0;i--){ //botton-up
            for(int j=C-2;j>=0;j--){//right-left
                int right = Math.max(hp[i][j+1]-dungeon[i][j],1);  //往右生命值最少为
                int down = Math.max(hp[i+1][j]-dungeon[i][j],1);   //往下生命值最少为
                hp[i][j] = Math.min(right,down);
            }
        }
        return hp[0][0];
    }
}
