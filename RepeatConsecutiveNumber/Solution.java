package RepeatConsecutiveNumber;

public class Solution {

    public static String repeatConsecutiveNumber(String s, int n) {
        StringBuilder res = new StringBuilder();
        if (s == null || s.length() == 0) {
            return res.toString();
        }
        int count = 1;
        res.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1) && count < n) {
                res.append(s.charAt(i));
                count++;
            }
            else if (s.charAt(i) == s.charAt(i-1)) {
                continue;
            } 
            else {
                res.append(s.charAt(i));
                count = 1;
            }
        }
        return res.toString();
    }

    
    public static void main(String args[]) {
        String s1 = "aab";
        String s2 = "aaaaabbbbaaaaa";
        String res1 = Solution.repeatConsecutiveNumber(s1, 1);
        String res2 = Solution.repeatConsecutiveNumber(s2, 2);
        System.out.println(res1);
        System.out.println(res2);
    }
}
