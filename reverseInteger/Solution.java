package reverseInteger;

public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x!=0) {
            int temp = x%10;
            int newRes = res*10+temp;
            if ((newRes-temp)/10!= res) {
                return 0;
            }
            x = x/10;
            res = newRes;
        }
        return res;
    }
}
