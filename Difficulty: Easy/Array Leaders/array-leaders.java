class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList <Integer> result = new ArrayList<>();
        int maxnum = arr[arr.length-1];
        result.add(maxnum);
        for(int i = arr.length -2;i>=0;i--){
            if(arr[i]>=maxnum){
                maxnum = arr[i];
                result.add(maxnum);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
