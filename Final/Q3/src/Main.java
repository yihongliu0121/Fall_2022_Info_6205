import java.util.Stack;
//minimum-remove-to-make-valid-parentheses, Time complexity O(N), Space complexity O(N)
public class Main {
    public static void main(String[] args) {
        System.out.println('"' + minRemoveToMakeValid("))((") + '"');
        System.out.println('"' + minRemoveToMakeValid("lee(t(c)o)de)") + '"');
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> bracketIndex = new Stack<>();
        boolean[] invalidIndex = new boolean[s.length()];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketIndex.push(i);
                invalidIndex[i] = true; //make every '(' as invalid first
            }
            if (s.charAt(i) == ')') {
                if (bracketIndex.empty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[bracketIndex.pop()] = false; //if there is ')' for '(' make the index valid
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndex[i]) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}

