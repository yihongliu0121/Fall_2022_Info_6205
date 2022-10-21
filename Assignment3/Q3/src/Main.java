public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Solution {
        List<String> res = new LinkedList<>();
        StringBuilder path = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return res;
            }
            backTracking(digits, 0);
            return res;
        }

        private String[] mapping = new String[] {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        private void backTracking(String digits, int startIndex) {
            if (startIndex == digits.length()) {
                res.add(path.toString());
                return;
            }

            String letters = mapping[digits.charAt(startIndex) - '0']; //get the corresponding letters for each digit

            for (int i = 0; i < letters.length(); i++) {
                path.append(letters.charAt(i));
                backTracking(digits, startIndex + 1); //change letters
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
