class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] arr = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        
        arr[0][0] = triangle.get(0).get(0);
        if(triangle.size() == 0 || triangle == null){
            return 0;
        }
        if(triangle.size() == 1){
            return arr[0][0];
        }
        
        int minSum = Integer.MAX_VALUE;
        
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> slab = triangle.get(i);
            for(int j = 0; j < slab.size(); j++){
                
                if(j == 0){
                    arr[i][j] = arr[i-1][j] + slab.get(j);
                    continue;
                }
                int up = (j == slab.size() - 1) ? arr[i-1][j-1] : arr[i-1][j];
                arr[i][j] = Math.min(arr[i-1][j-1], up) + slab.get(j);
            }
        }
        
        for(int num : arr[arr.length - 1]){
            minSum = Math.min(minSum, num);
        }
        
        return minSum;
    }
}
