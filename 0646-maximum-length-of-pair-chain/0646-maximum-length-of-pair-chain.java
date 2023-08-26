class Solution {
    public int findLongestChain(int[][] pairs) {
        List<List<Integer>> myList = new ArrayList<>();
        for(int i = 0 ; i < pairs.length ; i++){
            myList.add(List.of(pairs[i][0], pairs[i][1]));
            
        }
       

        
        Collections.sort(myList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        //System.out.println(myList);
        int max = 1;
        int min = myList.get(0).get(1);
        for(int i = 1 ; i < myList.size() ; i++){
            if( min <  myList.get(i).get(0)){
                max+=1;
                min = myList.get(i).get(1);
            }
        }
        return max;
        
    }
}