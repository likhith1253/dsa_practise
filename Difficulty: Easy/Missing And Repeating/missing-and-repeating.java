import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        
        int dup = findDuplicate(arr);
        result.add(dup);
        
        long n = arr.length;
        long actSum = (n * (n + 1)) / 2;
        long giveSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            giveSum += arr[i];
        }
        
        long diff = giveSum - actSum;
        int missing = (int) (dup - diff);
        result.add(missing);
        
        return result;
    }
    
    private int findDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return arr[i];
            }
            set.add(arr[i]);
        }
        return -1;
    }
}