class Solution {
    public long sumAndMultiply(int n) {
      long x=0,sum=0;
     String str=String.valueOf(n);
     for(int i=0;i<str.length();i++){
        if(str.charAt(i)!='0'){
        x=x*10+str.charAt(i)-'0';
        sum+=str.charAt(i)-'0';
        }
     }
   
     return x*sum;
    

    }
}