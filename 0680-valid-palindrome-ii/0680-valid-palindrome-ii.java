// class Solution {
//     public boolean validPalindrome(String s) {
//         int n=s.length();
//         int left=0;
//         int right=n-1;
//         while(left<right){
//             if(s[left]==s[right]){
//                 left--;
//                 right++;
//             }else(

//             )
//         }
//     }
// }

class Solution {
    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {

                // Check after removing left character
                int l = left + 1;
                int r = right;

                boolean skipLeft = true;

                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        skipLeft = false;
                        break;
                    }
                    l++;
                    r--;
                }


                // Check after removing right character
                l = left;
                r = right - 1;

                boolean skipRight = true;

                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        skipRight = false;
                        break;
                    }
                    l++;
                    r--;
                }


                return skipLeft || skipRight;
            }

            left++;
            right--;
        }

        return true;
    }
}