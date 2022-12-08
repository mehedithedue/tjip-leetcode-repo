import java.util.Arrays;
import java.util.HashMap;
/*
* https://leetcode.com/problems/two-sum/
*/
public class TwoSum {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> pairMap = new HashMap<>();

        /* The idea is if two number will add and will equal to target,
        I already have the next number if sub one number from target
         like 2 and 7 will be answered and target is 9
         so 9 - 2 = 7, so put 7 in a map for further processing, and "2"'s index in map value
         when 7 will come in loop, its already exist in map with its previous pair index ( in value ) and then just return the answer*/
        for (int i = 0; i < nums.length; i++) {
            int diffPair = target - nums[i];

            if (!pairMap.containsKey(nums[i])) {
                pairMap.put(diffPair, i);
            } else {
                answer[0] = pairMap.get(nums[i]);
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}
