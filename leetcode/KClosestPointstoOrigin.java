class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new PointComparator());
        
        for(int[] point : points){
            pq.add(point);
        }
        
        int[][] result = new int[K][2];
        int i = 0;
        while(K != 0){
            result[i++] = pq.poll();
            K--;
        }
        
        return result;
    }
    
    public class PointComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            return ((a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        }
    }
}
