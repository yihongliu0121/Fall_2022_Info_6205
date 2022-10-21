public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backTracking(nums, 0);
            return result;
        }

        private void backTracking(int[] nums, int startIndex) {
            result.add(new ArrayList<>(path));

            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                backTracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
