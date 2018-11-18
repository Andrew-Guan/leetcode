method1: 

It should work. But it exceeds the running time. 

method2:
 
It is much better and faster. It get a clear string first and then do the comparison. 
StringBuilder res = new StringBuilder();
res.reverse();
res.toString();

Another good way to determin a character is letter or number is:
 boolean res = Character.isLetterOrDigit(char ch);
