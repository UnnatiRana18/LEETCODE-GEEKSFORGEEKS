class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<2){
            return nums[0];
        }
        int size=nums.length;
        int ans=(nums[size-1]-1)*(nums[size-2]-1);
        return ans;
        
    }
}