package wordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || start.length() == 0 || end.length() == 0 || start.length() != end.length()) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        int level = 1;
        int curNum = 0;
        int lastNum = 1;
        queue.add(start);
        // visited add only when queue add
        visited.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            lastNum--;
            for (int i = 0; i < cur.length(); ++i) {
                char[] curArray = cur.toCharArray();
                for (char c = 'a'; c < 'z'; ++c) {
                    // replace one char at curArray and compare it to cur
                    curArray[i] = c;
                    String temp = new String(curArray);
                    // We have to use equals() here
                    if (temp.equals(end)) {
                        return level + 1;
                    }
                    if (dict.contains(temp) && !visited.contains(temp)) {
                        queue.add(temp);
                        visited.add(temp);
                        curNum++;
                    }
                }
            }
            if (lastNum == 0) {
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return 0;
    }
    
    public static void main(String args[]) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("log");
        dict.add("lot");
        System.out.println(Solution.ladderLength(start, end, dict));
    }
}
