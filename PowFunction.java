/*
* given x, n and d,

Input:   x = 2, n = 3, d = 3

Output: 2

2^3 % 3 = 8 % 3 = 2.

*/

public class Solution {
    public int pow(int x, int n, int d) {
          long res = 1; 
          int check = 0;
          if(x == 0){
            return 0;
          }
        if(n == 0){
            return 1;
        }
            if(x < 0){
              x = Math.abs(x);
            if(n%2 != 0){
                check = 1;
            }
            }
             long temp = x%d;
          while(n != 0){
               if(n%2 != 0){
                res = (res*temp)%d;
            }
            temp = temp*temp;
            temp = temp%d;
            n = n/2;
            if(res > d){
                res = res%d;
                 }
          }
           if(check == 1){
            return d-(int)res;
        }
          return (int)res;
             }
    
}




