class Solution {
    public class Athlete{
        int id;
        int score;
        public Athlete(int id, int score){
            this.id = id;
            this.score = score;
        }
    }
    public String[] findRelativeRanks(int[] nums) {
        String[] ans = new String[nums.length];
        PriorityQueue<Athlete> pq = new PriorityQueue<Athlete>(new AthleteComparator());
        
        for(int i = 0; i < nums.length; i++){
            pq.add(new Athlete(i, nums[i]));
        }
        
        int c = nums.length-1;
        
        while(!pq.isEmpty()){
            Athlete a = pq.poll();
            ans[a.id] = getRankString(c);
            c--;
        }
        
        return ans;
    }
    
    public String getRankString(int ctr){
        switch(ctr){
            case 0:
                return "Gold Medal";
            case 1:
                return "Silver Medal";
            case 2:
                return "Bronze Medal";
            default:
                return String.valueOf((ctr+1));
        }
    }
    
    public class AthleteComparator implements Comparator<Athlete>{
        @Override
        public int compare(Athlete a, Athlete b){
            return a.score - b.score;
        }
    }
}
