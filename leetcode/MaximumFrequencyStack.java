class FreqStack {
    HashMap<Integer, Stack<Integer>> group;
    HashMap<Integer, Integer> freqMap;
    int maxFreq;
    public FreqStack() {
        group = new HashMap<Integer, Stack<Integer>>();
        freqMap = new HashMap<Integer, Integer>();
        maxFreq = 0;
    }
    
    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, freq);
        maxFreq = Math.max(freq, maxFreq);
        group.computeIfAbsent(freq, y -> new Stack()).push(x);
    }
    
    public int pop() {
        int num = group.get(maxFreq).pop();
        freqMap.put(num, freqMap.get(num) - 1);
        if(group.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return num;
    }
}
