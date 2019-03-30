// Verified from LintCode
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int ctr = 0;
        int max = -1;
        for(Interval interval : intervals) {
            max = Math.max(max, interval.end);
        }

        System.out.println("Max time is : "+  max);
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
