import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Quiz5 test case");
        int[] arr = {0,0,1,1,1,2,2,5,8,9,10,11};
        int[] values = {1,4,5,10};
        System.out.println(Arrays.toString(getStartOfEachValues(arr, values)));
    }
    // arr = [0,0,1,1,1,2,2,5,8,9,10,11] sorted repeatable array
    // values = [1, 4, 5, 10]
    // output = [2, -1, 7, 10]
    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] res = new int[values.length];
        int index = 0;

        for (int i = 0; i < values.length; i++) {
            res[index] = findIndex(values[i], arr);
            index++;
        }
        return res;
    }

    private static int findIndex(int targetValue, int[] searchArray) {
        for (int i = 0; i < searchArray.length; i++) {
            if(searchArray[i] == targetValue) {
                return i;
            }
        }
        return -1;
    }
}