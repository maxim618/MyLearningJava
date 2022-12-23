import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11}, 10)));

    }
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if ((i != j)&&(nums[i] + nums[j] == target))
                    return new int[]{i, j};
            }
        }
        return new int[0];

    }
}
