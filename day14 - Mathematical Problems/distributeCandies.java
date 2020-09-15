/*

LeetCode Problem 1103

Distribute Candies to People

We distribute some number of candies, to a row of n = num_people people in the following way:

We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.

Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.

This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).

Return an array (of length num_people and sum candies) that represents the final distribution of candies.


Example 1:

Input: candies = 7, num_people = 4
Output: [1,2,3,1]
Explanation:
On the first turn, ans[0] += 1, and the array is [1,0,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0,0].
On the third turn, ans[2] += 3, and the array is [1,2,3,0].
On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].


Example 2:

Input: candies = 10, num_people = 3
Output: [5,2,3]
Explanation:
On the first turn, ans[0] += 1, and the array is [1,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0].
On the third turn, ans[2] += 3, and the array is [1,2,3].
On the fourth turn, ans[0] += 4, and the final array is [5,2,3].


Constraints:

1 <= candies <= 10^9
1 <= num_people <= 1000

*/


/*

Approach: Actually go through the process mentally and write code in the same way.
          I use the variable candyTracker since the person at index 0 gets 1 candy. It is easy to lose track of the
          original index if we try to modify the same. Keeping candyTracker and indexTracker makes understanding the code easier.

          Also, if there are more candies remaining to be distributed, however we have reached the end of the array,
          be sure to reset the indexTracker to 0.

Time Complexity: O(num_people), we essentially populate the result array, at least once

Space Complexity: O(num_people)

*/


public int[] distributeCandies(int candies, int num_people) {

        int[] result = new int[num_people];
        int candyTracker = 1, indexTracker = 0;

        while(candies > 0) {

            if(candyTracker <= candies) {

                result[indexTracker] += candyTracker;
                candies -= candyTracker;
                candyTracker++;
                indexTracker++;
            } else {
                result[indexTracker] += candies;
                candies = 0;    // We are out of candies
            }

            if(indexTracker == num_people && candies != 0)
                indexTracker = 0;

        }

        return result;
}
