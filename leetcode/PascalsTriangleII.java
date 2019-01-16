class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle= new ArrayList<List<Integer>>();
        
        for(int i = 0; i < rowIndex+1; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i+1; j++){
                if(j == 0 || j == i){
                    list.add(1);
                }
                else{
                    List<Integer> tempList = triangle.get(i-1);
                    int sum = tempList.get(j-1) + tempList.get(j);
                    list.add(sum);
                }
            }
            triangle.add(list);
        }
        return triangle.get(rowIndex);
    }
}
