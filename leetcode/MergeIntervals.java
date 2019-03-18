class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1 || intervals == null){
            return intervals;
        }
        
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> ans = new ArrayList();
        int i = 0, j = 1;
        while(i < intervals.size() && j < intervals.size()){
            Interval i1 = intervals.get(i);
            Interval i2 = intervals.get(j);
            // Can be merged
            if(i2.start <= i1.end){
                i1.end = Math.max(i1.end, i2.end);
                j++;
                continue;
            }
            ans.add(i1);
            i = j;
            j++;
        }
        ans.add(intervals.get(i));
        
        return ans;
    }
}
