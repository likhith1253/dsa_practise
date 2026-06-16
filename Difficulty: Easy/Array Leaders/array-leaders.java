class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
         ArrayList<Integer> result = new ArrayList<>();
        if(arr == null){
            return result;
        }
        int[] prefix = new int[arr.length];
       
        prefix[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length -2; i>=0;i--){
            if(prefix[i+1]<=arr[i]){
                prefix[i] = arr[i]; 
            }
            if(prefix[i+1]>arr[i]){
                prefix[i] = prefix[i+1];
            }
        }
        for(int k = 0; k<arr.length -1 ;k++){
            if(arr[k]>=prefix[k]){
                result.add(arr[k]);
            }
        }
        result.add(arr[arr.length - 1]);
        return result;
        
        
    }
}
