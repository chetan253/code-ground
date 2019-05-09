class Vector2D {
    List<Integer> list;
    int curr;
    public Vector2D(int[][] v) {
        list = new ArrayList<Integer>();
        for(int[] a : v){
            for(int num : a){
                list.add(num);
            }
        }
        curr = -1;
    }
    
    public int next() {
        return list.get(++curr);
    }
    
    public boolean hasNext() {
        return curr < list.size() - 1;
    }
}

