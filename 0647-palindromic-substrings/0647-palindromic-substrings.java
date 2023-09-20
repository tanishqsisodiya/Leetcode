class Solution {
    public static boolean ispalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(ch1 != ch2){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0;i< s.length();i++){
            for(int j = i+ 1;j <= s.length();j++){
               String ss = s.substring(i,j);
               if(ispalindrome(ss)==true){
                   count++; 
               }
            }
        }
        return count;
    }
}