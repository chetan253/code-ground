// Verified on LintCode
public class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int prev = 0;
        int max = -1;
        for(Interval interval : intervals) {
            max = Math.max(max, interval.end);
        }
        int[] arr = new int[max+1];
        for(Interval interval : intervals) {
            int startTime = interval.start;
            int endTime = interval.end;
            arr[startTime] += 1;
            arr[endTime] -= 1;
        }
        for(int i =0; i < arr.length; i++){
            if(arr[i] == 0) continue;
            arr[i] += prev;
            prev = arr[i];
            if(prev > 1)
                return false;
        }
        return true;    
    }
}
