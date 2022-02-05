/*
Initiate the counter to zero.
Iterate over kk from 1 to \sqrt{2N + \frac{1}{4}} - \frac{1}{2} 
2N+ 
4
1
 − 
2
1
 .
Decrease N by k, to keep xk term only.

Verify that x is an integer: N % k == 0. If it's the case, increase the counter by one.

Return the counter.

Time Complexity: O(Roote N)
Space Complexity: O(1).

*/


class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        // set upper limit
        int upper_limit = (int)(Math.sqrt(2 * N + 0.25) - 0.5);
        for (int k = 1; k <= upper_limit; ++k) {
            //Decrease NN by kk, to keep x kxk term only.
            N -= k;
            if (N % k == 0)
                count++;
        }
        return count;
    }
}
