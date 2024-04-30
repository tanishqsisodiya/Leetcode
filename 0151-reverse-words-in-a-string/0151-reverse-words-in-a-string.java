class Solution {
    public String reverseWords(String s) {
        String Str[] = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i = Str.length-1;i>=0;i--){
            sb.append(Str[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}