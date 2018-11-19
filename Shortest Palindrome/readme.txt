method1:

This method doesn't work well. The result is 119/120 passed. 
It exceed the time limit. 

method2:
I do not quite understand. 
The idea is to use two anchors j and i to compare the String from beginning and end.
If j can reach the end, the String itself is Palindrome. Otherwise, we divide the String by j, and get mid = s.substring(0, j) and suffix.

We reverse suffix as beginning of result and recursively call shortestPalindrome to get result of mid then appedn suffix to get result.
