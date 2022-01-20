package ca.jrvs.practice.codingChallenge;

public class ClimbingStairs {
    /**
     * O(2^n) time complexity
     * @param n
     * @return int
     */
    public int findSteps(int n) {
        if (n <= 2) {
            return n;
        }
        return (findSteps(n-1) + findSteps(n-2));
    }

    /**
     * O(n) time complexity
     * @param n
     * @return
     */
    public int findStepsDym (int n) {
        int [] ls = new int[n];
        ls[0] = 1;
        ls[1] = 2;
        for (int i = 3; i<=n; i++) {
            ls[i-1] = ls[i-2]+ls[i-3];
        }
        return ls[n-1];
    }
}
