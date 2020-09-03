/*

LeetCode Problem 739

Daily Temperatures

Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

*/




/*

My initial approach is to use brute force and solve the problem, and then optimize it.

This takes O(n^2) time

public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];

        int count = 1;    // For counting the number of days till next warmest day. Not kept it to 0, since 0 means there is no warm day ahead of current day.
        int k = 0;       // An auxiliary index to compare current element with and increment without disturbing for loop
        for(int i=0;i<T.length-1;i++)
        {
            count = 1;
            k = i+1;
            while(k<T.length-1 && T[k]<=T[i])
            {
                count++;
                k++;
            }
            if(T[k]<=T[i])
                result[i] = 0;
            else
                result[i] = count;
        }

        result[T.length-1] = 0;

        return result;

    }*

*/


    /*

      Optimal Approach: Use some extra memory to reduce runtime. A stack would work great in this case.

      For each temperature, store its index in the stack until we come across a greater temperature.
      At that point, write the result in the result array and move on to the next index.


      Time Complexity: O(n) since each element gets pushed and popped only once.

    */

    public int[] dailyTemperatures(int[] temperatures)
    {

        Stack<Integer> store = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++)
        {
            while(!store.isEmpty() && temperatures[i] > temperatures[store.peek()])
            {
                int index = store.pop();
                result[index] = i - index;
            }
            store.push(i);
        }

        return result;

    }
