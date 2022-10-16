import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums1 = {1,2,3,4,5,6,7};
        int k1 = 3;
        int[] nums2 = {-1,-100,3,99};
        int k2 = 2;

        int[] result1 = rotateArray(nums1, k1);
        int[] result2 = rotateArray(nums2, k2);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] rotateArray(int[] nums, int k) {
        int length = nums.length;
        int times = k % length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < times; i++) {
            stack.push(nums[length - 1]);
            length--;
        }

        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            if (!stack.isEmpty()) {
                result[i] = stack.pop();
            }
            else {
                result[i] = nums[index];
                index++;
            }
        }
        return result;
    }

}
