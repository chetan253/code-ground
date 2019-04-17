class MedianFinder {
    PriorityQueue<Integer> minQ;
    PriorityQueue<Integer> maxQ;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minQ = new PriorityQueue<Integer>((Integer a, Integer b) -> a - b);
        maxQ = new PriorityQueue<Integer>((Integer a, Integer b) -> b - a);
    }
    
    public void addNum(int num) {
        minQ.add(num);
        
        maxQ.add(minQ.poll());
        
        if(maxQ.size() > minQ.size()){
            minQ.add(maxQ.poll());
        }
    }
    
    public double findMedian() {
        if(minQ.size() == maxQ.size()){
            return (minQ.peek() + maxQ.peek())/2.0;
        }
        return  minQ.peek()/1.0;
    }
}
