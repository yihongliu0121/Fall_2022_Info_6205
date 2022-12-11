import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//group-anagrams, time complexity is O(N), space complexity is O(N)
public class Main {
    public static void main(String[] args) {
        String[] arr1 = {"eat","tea","tan","ate","nat","bat"};
        ArrayList<ArrayList<String>> result1 = groupAnagrams(arr1);
        String[] arr2 = {"a"};
        ArrayList<ArrayList<String>> result2 = groupAnagrams(arr2);
        String[] arr3 = {""};
        ArrayList<ArrayList<String>> result3 = groupAnagrams(arr3);
        System.out.println("TEST CASE 1 RESULT: ");
        System.out.println(result1);
        System.out.println("TEST CASE 2 RESULT: ");
        System.out.println(result2);
        System.out.println("TEST CASE 3 RESULT: ");
        System.out.println(result3);
    }

    private static ArrayList<ArrayList<String>> groupAnagrams(String[] arr) {
        ArrayList<ArrayList<String>> listOfGroupedAnagrams = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : arr) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String anagram = String.valueOf(ch); //eat become aet

            if (map.containsKey(anagram)) {
                ArrayList<String> tempList = map.get(anagram); //get the original list with key as "aet"
                tempList.add(str); //then add the new string to the list
                map.put(anagram, tempList); //update the map with updated list
            }

            else{
                ArrayList<String> tempList = new ArrayList<>(); //create a new list to hold the grouped anagrams
                tempList.add(str);
                map.put(anagram, tempList);
            }
        }

        for (ArrayList<String> list: map.values()) {
            listOfGroupedAnagrams.add(list); //get out all the list of grouped anagrams
        }

        return listOfGroupedAnagrams;
    }
}