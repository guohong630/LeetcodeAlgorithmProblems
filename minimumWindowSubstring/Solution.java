package minimumWindowSubstring;

import java.util.HashMap;

public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); ++i) {
            if (map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            } 
            else {
                map.put(T.charAt(i), 1);
            }
        }
        
        int minLen = S.length() + 1;
        int left = 0;
        int count = 0;
        int minStart = 0;
        // i is the same as right pointer
        for (int right = 0; right < S.length(); ++right) {
            if (map.containsKey(S.charAt(right))) {
                map.put(S.charAt(right), map.get(S.charAt(right))-1);
                if (map.get(S.charAt(right))>=0) {
                    count++;
                }
                // We don't use if map isEmpty() to decide if we have all char in T
                // we use a count parameter to do that, which is much easier to maintain
                // Notice we used while here
                while (count == T.length()) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }
                    if (map.containsKey(S.charAt(left))) {
                        map.put(S.charAt(left), map.get(S.charAt(left))+1);
                        // This is critical, we only change count when we get rid of repeated element
                        if (map.get(S.charAt(left))>0) {
                            count--;
                        }    
                    }
                    left++;
                }

            }
        }
        if(minLen>S.length())
        {
            return "";
        }
        return S.substring(minStart,minStart+minLen);
    }
}
