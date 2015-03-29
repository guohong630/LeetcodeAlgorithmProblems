package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int runner = 0;
        int walker = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (runner < s.length()) {
            if (!set.contains(s.charAt(runner))) {
                set.add(s.charAt(runner));
                runner++;
                if (max < runner - walker) {
                    max = runner - walker;
                }
            }
            else {
                set.remove(s.charAt(walker));
                walker++;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "bbbb";
        System.out.print(Solution.lengthOfLongestSubstring(s1));
    }
}
