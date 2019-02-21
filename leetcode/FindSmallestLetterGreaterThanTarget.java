class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(letters[mid] == target && letters[(mid+1) % letters.length] != target){
                return letters[(mid+1) % letters.length];
            }
            if(letters[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        if(left < letters.length && letters[left] > target){
            return letters[left];
        }
        return right >= 0 && target > letters[right] ? letters[(right+1) % letters.length] : letters[right];
    }
}
