class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       for(int i=0,j=m;i<n;j++){
        nums1[j]=nums2[i];
        i++;

       }
        Arrays.sort(nums1);
        
    }
}