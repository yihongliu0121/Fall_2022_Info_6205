public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) return result;
            backtrack(nums);
            return result;
        }

        public void backtrack(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
            }
            for (int i =0; i < nums.length; i++) {
                if (path.contains(nums[i])) {
                    continue;
                }
                path.add(nums[i]);
                backtrack(nums);
                path.removeLast();
            }
        }
    }
}
