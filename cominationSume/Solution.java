package cominationSume;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    } 

    public void helper(int[] candidates, int start, int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
            item.add(candidates[i]);
            helper(candidates, i, target-candidates[i], item, res);
            item.remove(item.size()-1);
        }
    }
}
