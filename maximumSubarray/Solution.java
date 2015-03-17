package maximumSubarray;

public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int localMax = A[0];
        int globalMax = A[0];
        for (int i = 1; i < A.length; i++) {
            localMax = Math.max(A[i], localMax+A[i]);
            globalMax = Math.max(globalMax, 0);
        }
        return globalMax;
    }
}
