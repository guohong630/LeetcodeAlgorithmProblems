package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.addAll(entry.getValue());
            }
        }
        return res;
    }
    
    
}