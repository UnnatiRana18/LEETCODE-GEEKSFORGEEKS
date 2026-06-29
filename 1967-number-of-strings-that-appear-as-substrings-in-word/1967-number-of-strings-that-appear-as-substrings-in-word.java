class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int No_of_Substrings=0;

        for( String i:patterns){
            if(word.contains(i)){
                No_of_Substrings++;
            }
        }
        return No_of_Substrings;
        
    }
}