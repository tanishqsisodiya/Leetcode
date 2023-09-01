class LFUCache {
 class Node{
        int val;
        int key;
        int count;
    }
    
    int minCount;
    int cap;
    Map<Integer, Node> m; // k: key, v: node
    Map<Integer, LinkedHashSet<Node>> countToNodes; // k: count, v: a linked hashset of all nodes that their keys are equal to count
    
    public LFUCache(int capacity) {
        minCount = 1;
        cap = capacity;
        countToNodes = new HashMap<>();
        m = new HashMap<>();
    }
    
    public int get(int key) {
        if (!m.containsKey(key)){
            return -1;
        } 
        Node cur = m.get(key);
        // remove key from current count (since we will inc count)
        countToNodes.get(cur.count).remove(cur); 
        if (cur.count == minCount && countToNodes.get(cur.count).size() == 0){
            minCount++; // nothing in the current minCount bucket
        }
        cur.count++;
        
        if(!countToNodes.containsKey(cur.count)){ // a new count
            countToNodes.put(cur.count, new LinkedHashSet<>()); 
        }
        countToNodes.get(cur.count).add(cur);
        return m.get(key).val;
    }
    
    public void put(int key, int value) {
        if (m.containsKey(key)) {
            m.get(key).val = value;
            get(key); // update key's count
            return;
        } 
        
        if (m.size() >= cap){
            Node nodeToRemove = countToNodes.get(minCount).iterator().next();
            countToNodes.get(minCount).remove(nodeToRemove);
            m.remove(nodeToRemove.key);
        }
        
        minCount = 1;
        Node cur = new Node();
        cur.val = value;
        cur.count = minCount;
        cur.key = key;
        m.put(key, cur);
        if(!countToNodes.containsKey(cur.count)){
            countToNodes.put(cur.count, new LinkedHashSet<>());
        }
        countToNodes.get(cur.count).add(cur);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */