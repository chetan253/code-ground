class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalTime = 0;
        if(timeSeries.length == 0){
            return totalTime;
        }
        int nextEffect = 0;
        for(int i = 0; i < timeSeries.length; i++){
            if(i == 0){
                totalTime += duration;
                nextEffect = timeSeries[i] + duration;
                continue;
            }
            if(nextEffect <= timeSeries[i]){
                totalTime += duration;
                nextEffect = timeSeries[i] + duration;
            }
            else{
                if(timeSeries[i] + duration > nextEffect){
                    int offset = timeSeries[i] + duration - nextEffect; 
                    totalTime += offset;
                    nextEffect += offset;
                }
            }
        }
        return totalTime;
    }
}
