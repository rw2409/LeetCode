package wr.leetcode.algo.paint_house_ii;

public class Solution {
    private int minIndex(int[][] dp, int i, int ignore) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        int k = dp[i].length;
        for (int j = 0; j < k; ++j) {
            if(j != ignore && dp[i][j] < min) {
                min = dp[i][j];
                index = j;
            }
        }
        return index;
    }

    public int minCostII(int[][] costs) {
        int ret = 0;
        if ( costs.length > 0 && costs[0].length > 0) {
            int n = costs.length;
            int k = costs[0].length;
            int[][] dp = new int[n][k];

            int minIndex = 0;
            int secondMin = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < k; ++j) {
                    dp[i][j] += costs[i][j];
                    if( i == 0) {
                        continue;
                    }
                    if(1 == k) {
                        dp[i][j] += dp[i-1][j];
                    } else if( j == minIndex ) {
                        dp[i][j] += dp[i-1][secondMin];
                    } else {
                        dp[i][j] += dp[i-1][minIndex];
                    }
                }
                minIndex = minIndex(dp, i, -1);
                secondMin = minIndex(dp, i, minIndex);
            }
            ret = dp[n-1][minIndex];
        }
        return ret;
    }

       /*
    public int minCostII(int[][] costs) {
        int ret = 0;
        if( null != costs && 0 < costs.length && costs[0].length > 0) {
            int n = costs.length;
            int k = costs[0].length;
            int [][] minCosts = new int[k][2];

            for (int i = 1; i <= n; ++i ) {
                int minColor = minColor(i-1, -1, minCosts);
                int subColor = minColor(i-1, minColor, minCosts);
                for (int color = 0; color < k; ++color) {
                    int prev;
                    if(color == minColor) {
                        prev = minCosts[subColor][(i-1)%2];
                    } else {
                        prev = minCosts[minColor][(i-1)%2];
                    }
                    minCosts[color][i%2] = prev + costs[i-1][color];
                }

            }
            int lastColor = minColor(n, -1, minCosts);
            ret = minCosts[lastColor][n%2];
        }
        return ret;
    }


    int minColor( int day, int skipColor, int[][] minCosts ) {
        int k = minCosts.length;
        int minColor = 0;

        if( k > 1 ) {
            int minValue = Integer.MAX_VALUE;
            minColor = -1;
            for (int color = 0; color < minCosts.length; ++color) {
                if(skipColor != color && minCosts[color][day%2] < minValue ) {
                    minValue = minCosts[color][day%2];
                    minColor = color;
                }
            }
        }
        return minColor;
    }

    public static void main(String[] args) {
        int[][] arr = {{8}};
        Solution sol = new Solution();
        System.out.println(sol.minCostII(arr));
    }

    //BUG: Wrong fix

    int minColor( int day, int skipColor, int[][] minCosts ) {
        int minValue = minCosts[0][day%2];
        int minColor = 0;
        for (int color = 1; color < minCosts.length; ++color) {
            if(skipColor != color && minCosts[color][day%2] < minValue ) {
                minValue = minCosts[color][day%2];
                minColor = color;
            }
        }
        return minColor;
    }*/

    //BUG: cannot deal with single color, single day
    /*
    int minColor( int day, int skipColor, int[][] minCosts ) {
        int minValue = Integer.MAX_VALUE;
        int minColor = -1;
        for (int color = 0; color < minCosts.length; ++color) {
            if(skipColor != color && minCosts[color][day%2] < minValue ) {
                minValue = minCosts[color][day%2];
                minColor = color;
            }
        }
        return minColor;
    }*/
}
