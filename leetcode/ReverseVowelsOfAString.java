class Solution {
    public String reverseVowels(String s) {

        char[] vowel = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        HashSet<Character> vowels = new HashSet<Character>();
        for(int i = 0; i < vowel.length; i++){
            vowels.add(vowel[i]);
        }
        int i = 0, j = s.length()-1;
        char[] arr = s.toCharArray();
        boolean flag1 = false, flag2 = false;
        while(i < j){
            char ci = arr[i];
            char cj = arr[j];
            if(vowels.contains(ci))
                flag1 = true;
            else{
                i++;
                flag1 = false;
            }
            if(vowels.contains(cj))
                flag2 = true;
            else{
                j--;
                flag2 = false;
            }
            if(flag1 && flag2){
                arr[i] = cj;
                arr[j] = ci;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
