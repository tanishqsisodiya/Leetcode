class SummaryRanges {

  TreeMap<Integer, Integer> tm;
    public SummaryRanges() {
        tm = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(tm.containsKey(val))
        {
            return;
        }
        
        Integer lower = tm.lowerKey(val);
        Integer higher = tm.higherKey(val);
        // Condition 1
        if(lower!=null && higher!=null && tm.get(lower) == val-1 && higher == val+1)
        {
            tm.put(lower, tm.get(higher));
            tm.remove(higher);
        }
		// Condition 2
        else if(lower!=null && tm.get(lower)+1 >= val)
        {
            tm.put(lower, Math.max(tm.get(lower), val));
        }
		// Condition 3
        else if(higher!=null  && higher == val+1)
        {
            tm.put(val, tm.get(higher));
            tm.remove(higher);
        }
        else
        {
            tm.put(val,val);
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        for(int a:tm.keySet()){
            res.add(new int[]{a,tm.get(a)});
        }
        return res.toArray(new int[tm.size()][2]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */