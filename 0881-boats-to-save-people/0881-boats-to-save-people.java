class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int count = 0;
        int left = 0;
        int right = n-1;
        while(left<=right){
            if((left!=right) && (people[left] + people[right]<=limit)){
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}