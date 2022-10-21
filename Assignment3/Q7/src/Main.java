public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new LinkedList<>();
            StringBuilder curStr = new StringBuilder();
            backtrack(res, curStr, 0, 0, n);
            return res;
        }

        public void backtrack(List<String> res, StringBuilder curStr, int open, int close, int max) {
            if (open == max & close == max) {
                res.add(curStr.toString());
                return;
            }

            if (open < max) {
                curStr.append('(');
                backtrack(res, curStr, open + 1, close, max);
                curStr.deleteCharAt(curStr.length() - 1);
            }

            if (close < open) {
                curStr.append(')');
                backtrack(res, curStr, open, close + 1, max);
                curStr.deleteCharAt(curStr.length() - 1);
            }
        }
    }
}
