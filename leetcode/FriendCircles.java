class Solution {
    
    public int findParent(int[] arr, int num){
        if(arr[num] == -1){
            return num;
        }
        arr[num] = findParent(arr, arr[num]);
        return arr[num];
    }
    
    public void union(int[] arr, int num1, int num2){
        int x = findParent(arr, num1);
        int y = findParent(arr, num2);
        if(x != y){
            arr[x] = y;
        }
    }
    
    public int findCircleNum(int[][] M) {
        int[] arr = new int[M.length];
        Arrays.fill(arr, -1);
        
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M.length; j++){
                if(M[i][j] == 1)
                    union(arr, i, j);
            }
        }
        
        int ctr = 0;
        
        for(int i : arr){
            if(i == -1)
                ctr++;
        }
        
        return ctr;
    }
}
