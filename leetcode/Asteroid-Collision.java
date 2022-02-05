/*
Time Complexity: O(N), where NN is the number of asteroids. Our stack pushes and pops each asteroid at most once.

Space Complexity: O(N). We use a stack to keep track of the intermediate results. In the worst case, the states do not evolve at the end, i.e. we need O(N)O(N) space where NN is the number of input asteroids.
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) 
{
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
