import java.util.Arrays;

public class KRadiusSubarrayAverages_2090 {

    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        //creating a new array of the same length as nums array for returning
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1); //filling the new array with -1
        long windowSize = 2 * k + 1; //if k is 3, you have to check for 3
        // boxes to the left and the right i.e, 2*k and we should also
        // consider the box where we are counting it from so that will be +1.
        // so overall it will be 2*k+1

        //edgecases
        if (k == 0){
            return nums;
        }

        if(windowSize > n){
            return avgs;
        }

        /*
        Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
        Output: [-1,-1,-1,5,4,4,-1,-1,-1]
         */
        long windowSum = 0; //initialized the new windowsum
        for(int i = 0; i< windowSize; i++){
            windowSum += nums[i];
        }

        avgs[k] = (int)(windowSum/windowSize); //inserting the value to the
        // new array at the correct position

        //
        for(int i = (int)windowSize; i<n; i++){
            //sliding window deducting one from the beginning and adding one
            // next value
            windowSum = windowSum - nums[i - (int)windowSize] + nums[i];
            // inserting the value to the next correct position
            avgs[i-k] = (int)(windowSum/windowSize);
        }

        return avgs;
    }

    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int k=3;
        int[] avgs = getAverages(nums, k);
        System.out.println(Arrays.toString(avgs));

//        for (int value : avgs){
//            System.out.println(value);
//        }
//        Arrays.stream(avgs).forEach(System.out::println);
    }
}

/*
2090. K Radius Subarray Averages

You are given a 0-indexed array nums of n integers, and an integer k.
The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.
For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.


Example 1:

Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
Output: [-1,-1,-1,5,4,4,-1,-1,-1]
Explanation:
- avg[0], avg[1], and avg[2] are -1 because there are less than k elements before each index.
- The sum of the subarray centered at index 3 with radius 3 is: 7 + 4 + 3 + 9 + 1 + 8 + 5 = 37.
  Using integer division, avg[3] = 37 / 7 = 5.
- For the subarray centered at index 4, avg[4] = (4 + 3 + 9 + 1 + 8 + 5 + 2) / 7 = 4.
- For the subarray centered at index 5, avg[5] = (3 + 9 + 1 + 8 + 5 + 2 + 6) / 7 = 4.
- avg[6], avg[7], and avg[8] are -1 because there are less than k elements after each index.
Example 2:

Input: nums = [100000], k = 0
Output: [100000]
Explanation:
- The sum of the subarray centered at index 0 with radius 0 is: 100000.
  avg[0] = 100000 / 1 = 100000.
Example 3:

Input: nums = [8], k = 100000
Output: [-1]
Explanation:
- avg[0] is -1 because there are less than k elements before and after index 0.


Constraints:

n == nums.length
1 <= n <= 105
0 <= nums[i], k <= 105
 */