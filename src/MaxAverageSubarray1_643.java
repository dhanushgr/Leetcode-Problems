public class MaxAverageSubarray1_643 {

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        //1st iteration to calculate the initial value of subarray
        for (int i = 0; i<k; i++){
            sum += nums[i];
        }
        int maxsum = sum;   //making the 1st iteration sum to save in maxsum
        //iterating through the array in Sliding Window form.
        for (int i=k; i<nums.length;i++){
            sum += nums[i]; //adding the next value
            sum -= nums[i-k]; //removing the 1st value which was added
            maxsum = Math.max(maxsum, sum); //comparing which is maximum
        }
        return (double) maxsum/k; //to calculate the average.
    }


    //Main function which gives the nums array and the number of subarray(k)
    // im using this to print out the solution to the console
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}


/* Leetcode question 643
643. Maximum Average Subarray I
Easy
Topics
Companies
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.



Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000


Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 */