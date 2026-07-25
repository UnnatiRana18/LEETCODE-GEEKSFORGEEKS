class Solution {
    public int missingNumber(int[] nums) {
        int end=nums.length;
        int totalsum = (end*(end+1))/2;
        int arrsum=0;
        for(int i=0;i<end;i++){
            arrsum+=nums[i];
        }

        int ans=totalsum-arrsum;
        return ans;
    }
}