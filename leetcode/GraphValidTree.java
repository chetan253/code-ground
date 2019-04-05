class Solution {
    
    public int findParent(int[] arr, int x){
        if(arr[x] == -1){
            return x;
        }
        arr[x] = findParent(arr, arr[x]);
        return arr[x];
    }
    
    public void union(int[] arr, int x, int y){
        int pX = findParent(arr, x);
        int pY = findParent(arr, y);
        
        if(pX != pY){
            arr[pX] = pY;
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        if(n == 1 && edges.length == 0){
            return true;
        }
        if(edges.length == 0 ||  n == 0 ){
            return false;
        }
        
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        
        for(int[] edge: edges){
            if(findParent(arr, edge[0]) == findParent(arr, edge[1])){
                return false;
            }
            union(arr, edge[0], edge[1]);
        }
        
        int countRoots = 0;
        for(int num : arr){
            countRoots = num == -1 ? countRoots + 1: countRoots;
        }
        
        return countRoots == 1;
    }
}
