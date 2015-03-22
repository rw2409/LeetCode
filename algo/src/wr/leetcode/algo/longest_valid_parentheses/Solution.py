class Solution:
    # @param s, a string
    # @return an integer
    def longestValidParentheses(self, s):
        if s is None:
        	s = ""

        n = len(s)

        dp = [[False for i in xrange(n+1)] for j in xrange(n+1)]
        ret = 0

        # string[j, j+i-1]
        for i in xrange(0, n+1):
        	for j in xrange(n-i+1):
        		if i == 0 :
        			dp[i][j] = True
        			continue
        		if i == 1:
        			continue
        		if i == 2 :
        			dp[i][j] = (s[j] == '(' and s[i+j-1] == ')')
        			ret = 2
        			continue
        		dp[i][j] = (s[j] == '(' and s[i+j-1] == ')' and dp[i-2][j+1]) or (s[i+j-2] == '(' and s[i+j-1] == ')' and dp[i-2][j]) or (s[j] == '(' and s[j+1] == ')' and dp[i-2][j+2])
        		if dp[i][j]:
        			ret = i
        	if (i-ret) >= 2:
        		break 
        return ret

if __name__ == '__main__':
	sol = Solution()
	print sol.longestValidParentheses(")()())")
	print sol.longestValidParentheses("((())())(()))(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()()))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(())()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())(()((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()()()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())(())))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()((()))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((()))))()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))()))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())())()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))(()())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()()))((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()(((((()(()))))()()((()())((()())()(())((()))()()(()))")
	print sol.longestValidParentheses("))))())(())()))(()()(())(())()))(((()()))()()))(())(())()())()(()())((()(((())()())(()())(())((()))))())()))()(())))())()))(()))((()())((()(())))(()))))))))((())(()()((())()()(()))))(((()(())))())))()())))())()()())()(())()(((())()))()()())))()())))()((((((())((())))((())())(((()())())()((((((()())((()()(())(()))(()())()))()(()(()())(()))((())((())))))()()))))()())()))))((((())(())))((()))(()()()()()((())((((())())()())()())(()(()()))())(((()())(()))()))(())()((()(())))))()())())()()(())))((())()()()))(())((()())))))((()((((()(((())()))))(()))()()))(()(())(()((()()()))))()))()()(((()()(())())()(())(()()()))()(()())))()((()((()))))())()(())()(()()((()()())(((())((())))(()())))()))()()())()))((()))(((()()()((()))))()()()))()))())())))))())()))(()))))(()()()))()((())))((())))()))(()()()()()()(()))())())(((())))(())(()(()())((()()()()))()()(()()))(()())(()()()((()()(((()(()((()((((()((())((()()))))))()())())(()(())()((((()()()()()))))()())()((())))))))()(((()())))()(()()(()()()()))()((((()((())(())))())))(()()()())()))))))((()))())((())(()(()(((()()()((((()()))())()())()())()))))())()(((()))))()()())))(())())))(())())((()))(())))(((()()))((((()))(()()))())((()())(()))(()(())(()(()))((((((()()(()()(()))()(()(())((((((((()(()())((())))())()())(()(()()))))(()(()()()))(()((()(((())((())(())()(()()())(()))())((()((((((())())(())()(()()(()())(())())()()))())(()))(())))()())))()()((()))())()()(())(()())()())())())))()()))((((()((()(())(((())()((())(())())))))()(()))())()))())(((())))))((((()(()()))))(((())(((())((())))))()()))()(()(((((((()))))((()))())()(())()))())())((()))))((())(())))(((())((((()(())(())()(((((())))()))()(()())(()()(())()(((()))())())))()))()()())((")