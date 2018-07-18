public class code134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gassum=0;
        int costsum =0;
        int sum =0;
        for(int i=0;i<gas.length;i++){
            gassum+=gas[i];
            costsum+=cost[i];
            sum+=i;
        }
        if (costsum>gassum){
            return -1;
        }
        for(int i=0;i<gas.length;i++){
            int gasincar = 0;
            for(int j=0;j<gas.length;j++){
                int index = j+i;
                if(index>gas.length-1){
                    index = index - gas.length;
                }
                gasincar+=gas[index];
                if(gasincar<cost[index]){
                    sum-=i;
                    break;
                }
                gasincar-=cost[index];
            }
        }
        return sum;
    }
}
