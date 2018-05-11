class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> arrList = new ArrayList<List<Integer>>();
        int startpos = 0, ctr = 1;
        for(int i = 1; i < S.length(); i++){
            while(S.charAt(i) == S.charAt(startpos)){
                i++;
                ctr++;
                if(i >= S.length()){
                    break;
                }
            }
            if(ctr >= 3){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(startpos);
                a.add(i-1);
                arrList.add(a);
            }
            startpos = i;
            ctr = 1;
        }
        return arrList;
    }
}
