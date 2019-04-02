public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int ctr = 0;
        int max = -1;
        if(intervals.length == 0){
            return 0;
        }
        
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
        ctr = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i] += arr[i-1];
            ctr = Math.max(ctr, arr[i]);
        }
        return ctr;
    }
}
