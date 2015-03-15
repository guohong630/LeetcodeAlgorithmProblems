package permutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num==null && num.length==0)
            return res;
        // for repeated element problem, 
        // normally we need to sort the element.
        Arrays.sort(num);
        helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
        return res;
    }
    private static void helper(int[] num, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res)
    {
        if(item.size() == num.length)
        {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=0;i<num.length;i++)
        {
            // don't understand who both used[i-1] and !used[i-1] work
            if(i>0 && used[i-1] && num[i]==num[i-1]) continue;
            if(!used[i])
            {
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, res);
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }
    
    public static void main(String args[]) {
        int[] num = new int[]{1,1,1,2,2};
        System.out.println(Solution.permuteUnique(num).size());
    }  
}
