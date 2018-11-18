method1:

In SE7, there is no good way to transter Integer[] to int[]. We can only use for loop to create a new int array.

To initialize an empty int array, it is int[] res = new int[0];

method2:

It said the complexity of this method is O(n)(O(m + n) where m and n are lengths of both the arrays.). For the first method, it is O(nlogn).
But according to the running time I get, the first method is faster than the second one.
