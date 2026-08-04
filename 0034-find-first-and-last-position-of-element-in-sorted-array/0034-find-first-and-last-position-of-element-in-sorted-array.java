class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }


    // Finding first occurrence
    public int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {

                ans = mid;        // store answer
                right = mid - 1;  // search left side

            }
            else if(nums[mid] < target) {

                left = mid + 1;

            }
            else {

                right = mid - 1;

            }
        }

        return ans;
    }


    // Finding last occurrence
    public int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {

                ans = mid;        // store answer
                left = mid + 1;   // search right side

            }
            else if(nums[mid] < target) {

                left = mid + 1;

            }
            else {

                right = mid - 1;

            }
        }

        return ans;
    }
}