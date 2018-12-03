method1:

1. When I want to create a one dimention array with size 1. 
I initial the array in this way: int[] res = new int[0]; res[0] = 1;
This is wrong, causing index out of boundry exception. 

The correct one should be int[] res = new int[1]; res[0] = 1;

2. When I combine two arrays into one array, I can use the following method:
      public int[] plusOne(int[] digits) {
            int[] res = new int[1];
            res[0] = 1;
            digits[0] = 0;
            int length = digits.length;
            int[] output = new int[length+1];
            System.arraycopy(res, 0, output, 0, 1);
            System.arraycopy(digits, 0, output, 1, length);
            ...


method2:

It is much cleaner. 
