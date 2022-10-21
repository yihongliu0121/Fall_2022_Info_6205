public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Solution {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            backTracking(candidates, target, 0);
            return result;
        }

        private void backTracking(int[] candidates, int target, int startIndex) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                result.add(new LinkedList<>(path));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                path.add(candidates[i]);
                backTracking(candidates, target - candidates[i], i);
                path.removeLast();
            }
        }
    }

}
