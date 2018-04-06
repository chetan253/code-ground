class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, ctr = 0;
        int[] temp = new int[m+n];
        while(i < m && j < n){
            if(nums1[i] <= nums2[j])
                temp[ctr] = nums1[i++];
            else if(nums1[i] > nums2[j])
                temp[ctr] = nums2[j++];
            ctr++;
        }
        while(i < m)
            temp[ctr++] = nums1[i++];
        while(j < n)
            temp[ctr++] = nums2[j++];
        i = 0;
        while(i < ctr){
            nums1[i] = temp[i];
            i++;
        }
    }
}
