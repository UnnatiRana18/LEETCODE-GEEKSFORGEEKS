class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int size=arr.length;
        arr[0]=1;

        for(int i=1;i<size;i++){
           
            if(arr[i]-arr[i-1]>1){
                arr[i]=arr[i-1]+1;
            }
        }
        int max = arr[size-1];
        return max;
        
    }
}