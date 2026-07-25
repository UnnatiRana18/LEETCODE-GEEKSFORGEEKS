class Solution {
    public int reverse(int x) {
        int nums=Math.abs(x);
         int ans=0;
       while(nums!=0){
        int digit=nums%10;
    
        if(ans>(Integer.MAX_VALUE-digit)/10){
            return 0;
        }
        ans = ans * 10 + digit;
        nums=nums/10;
       }
         return ( x< 0) ? (-ans):(ans);
    }
   
}