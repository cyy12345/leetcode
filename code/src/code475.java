import java.util.Arrays;

public class code475 {
    //做这道题的时候，应该从house的角度考虑，遍历house的情况，找到需要满足的最小值中的最大值
    /*
    Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
     */
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0)
            return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int firstHtr = heaters[0];
        int lastHtr = heaters[heaters.length - 1];
        int j = 1;
        int min = 0;
        for (int h : houses) {
            if (h <= firstHtr) {
                min = Math.max(min, firstHtr - h);
                continue;
            }
            if (h >= lastHtr) {
                min = Math.max(min, houses[houses.length - 1] - lastHtr);
                break;
            }
            while (h >= heaters[j])
                j++;
            min = Math.max(min, Math.min(h - heaters[j - 1], heaters[j] - h));
        }
        return min;
    }

    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }
}
