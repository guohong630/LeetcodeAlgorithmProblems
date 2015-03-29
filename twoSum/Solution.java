package twoSum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                res[0] = i+1;
                res[1] = map.get(temp);
            }
            else {
                map.put(numbers[i], i+1);
            }
        }
        if (res[0] > res[1]) {
            int temp = res[1];
            res[1] = res[0];
            res[0] = temp;
        }
        return res;
    }
    
    
}
