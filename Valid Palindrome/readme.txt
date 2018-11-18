method1: 

It should work. But it exceeds the running time. 

method2:
 
It is much better and faster. It get a clear string first and then do the comparison. 
StringBuilder res = new StringBuilder();
res.reverse();
res.toString();

Another good way to determin a character is letter or number is:
 boolean res = Character.isLetterOrDigit(char ch);

Another clean solution is as follows:
public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuilder(actual).reverse().toString();
        return actual.equals(rev);
    }
}
