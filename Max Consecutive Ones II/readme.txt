method1:

I update the method based on Max Consecutive Ones.

The idea is to keep a window [l, h] that contains at most k zero


method2: 

It does not handle follow-up, because nums[l] will need to access previous input stream
Time: O(n) Space: O(1)



method3:

Now let's deal with follow-up, we need to store up to k indexes of zero within the window [l, h] so that we know where to move l next when the window contains more than k zero. If the input stream is infinite, then the output could be extremely large because there could be super long consecutive ones. In that case we can use BigInteger for all indexes. For simplicity, here we will use int
Time: O(n) Space: O(k)
Note that setting k = 0 will give a solution to the earlier version Max Consecutive Ones


method4:

For k = 1 we can apply the same idea to simplify the solution. Here q stores the index of zero within the window [l, h] so its role is similar to Queue in the above solution
