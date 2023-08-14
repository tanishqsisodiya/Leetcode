class Solution {
    HashSet<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(); 
        List<String> result = new ArrayList<>(); 
        for(String word : words){
            set.add(word);
        }
    // Iterate over the array
        for(String word : words){ 
            int sz = word.length();
        // Putting flags where the smaller valid string ends 
            boolean[] flags = new boolean[sz + 1]; 
            flags[0] = true;
            //Iterate over the string
            for(int i = 0; i < sz; i++){
            //Skipping already included characters
                if(!flags[i]){ 
                    continue;
                }
            //Finding substrings which are present in the word array
                for(int k = i + 1; k <= sz; k++){
                  if(k - i < sz && set.contains(word.substring(i, k))){
                      flags[k] = true; // put down the flag where the selected smaller string ends 
                  }  
                }
            //If the string is successfully made
            //by combination of other strings add it to the result and break out of
            //the loop to avoid adding repeated strings to the result
                if(flags[sz]){ 
                    result.add(word); 
                    break;
                }
            }
        }
        return result;
    }
}