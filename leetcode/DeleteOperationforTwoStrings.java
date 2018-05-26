class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] op = new int[w2.length + 1][w1.length + 1];
        
        op[0][0] = 0;
        for(int i = 1; i < op.length; i++){
            op[i][0] = i;
        }
        for(int j = 1; j < op[0].length; j++){
            op[0][j] = j;
        }
        
        for(int i = 1; i < op.length; i++){
            for(int j = 1; j < op[i].length; j++){
                /*if both the elements are same we just need to take diagonal value as the min delete operations
                for the previous chars pressent if any they will need to be modified but same chars won't*/
                if(w2[i-1] == w1[j-1]){
                    op[i][j] = op[i-1][j-1];
                }
                /*if both the chars are different then to make string equal with minimum deletions we will take 
                min of upper and left deletions and add 1 more deletion(for current char) so they become equal*/
                else{
                    op[i][j] = Math.min(op[i-1][j], op[i][j-1]) + 1;
                }
            }
        }
        return op[w2.length][w1.length];
    }
}
