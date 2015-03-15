package restoreIPAddress;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(s, 0, 1 , " ", res);
        return res;
    }
    
    public static void helper(String s, int start, int segment , String item , ArrayList<String> res) {
        if (start > (s.length() - 1)) {
            return;
        }
        
        if (start > 11) {
            return;
        }
        
        if (segment == 4) {
            String str = s.substring(start);
            if (isValid(str)) {
               res.add(item + "." + str);
               
            }
        }
        
        for (int i = 1; i < 4 && (start + i<= s.length()); i++) {
            String str = s.substring(start, start  + i);
            if (isValid(str)) {
                if (segment == 1) {
                    helper(s, start + i, segment + 1, str, res);
                }
                else {
                    helper(s, start + i, segment + 1, item + "." + str, res);
                }
            }
        }
    }
    
    public static boolean isValid(String s) {
        if (s == null || s.length() > 3) {
            return false;
        }
        
        int num = Integer.parseInt(s);
        if (s.charAt(0) == 0 && s.length() > 1) {
            return false;
        }
        
        if (num<0 || num>255) {
            return false;
        }
        
        return true;
    }
    
    public static void main (String args[]) {
        String s = "25525511135";
        List<String> res = Solution.restoreIpAddresses(s);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
 