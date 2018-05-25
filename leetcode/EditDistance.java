class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] edits = new int[w2.length + 1][w1.length + 1];
        
        edits[0][0] = 0;
        for(int i = 1; i < edits.length; i++){
            edits[i][0] = i;
        }
        for(int j = 1; j < edits[0].length; j++){
            edits[0][j] = j;
        }
        
        for(int i = 1; i < edits.length; i++){
            for(int j = 1; j < edits[i].length; j++){
                //if both are same chars no edits are required for current position
                if(w1[j-1] == w2[i-1]){
                    edits[i][j] = edits[i-1][j-1];
                }
                else{
                    edits[i][j] = Math.min(Math.min(edits[i-1][j], edits[i][j-1]), edits[i-1][j-1]) + 1;
                }
            }
        }
        return edits[w2.length][w1.length];
    }
}<Paste>
