public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Solution {

        List<Integer> res = new ArrayList<>();
        public int[] numsSameConsecDiff(int n, int k) {

            for(int num = 1; num < 10; num++){ // first digit can't be 0
                find(num, n-1, k); // find remaining n-1 digits using backtrack
            }

            return res.stream().mapToInt(Integer::intValue).toArray();  // convert list to int arr
        }

        private void find(int num, int n, int k){

            if(n == 0){
                res.add(num);
                return;
            }

            for(int i = 0; i < 10; i++){
                if(Math.abs(num % 10 - i) == k) // find digit that have k difference with last digit
                    find(num*10 + i, n-1, k);
            }
            num /= 10;
        }
    }
}
