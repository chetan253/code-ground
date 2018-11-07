class Solution {
    int[] arr = new int[1001];
    
    public void union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);
        arr[xParent] = yParent;
    }
    
    public int find(int x){
        if(arr[x] == -1){
            return x;
        }
        arr[x] = find(arr[x]);
        return arr[x];
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        if(edges.length == 0){
            return new int[]{};
        }
        ArrayList<int[]> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }
        
        for(int i = 0; i < edges.length; i++){
            if(find(edges[i][0]) == find(edges[i][1])){
                arrList.add(edges[i]);
            }
            else{
                union(edges[i][0], edges[i][1]);
            }
        }
        return arrList.get(arrList.size()-1);
    }
}
