package function;

import java.util.*;
public class function {
//     public static int calculateProduct(int a ,int b) {
//       return a*b;
//         }
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//     int  a= sc.nextInt();
//     int  b= sc.nextInt();
// System.out.println("Product of a and b is "+calculateProduct(a, b));
public static void calculateFactorials(int n ){
        //////////Loop

        if(n < 0){
            System.out.println("Invalid Number");
        return;
        }
int factorial = 1;
for(int i =n; i>1;i--){
factorial = factorial*i;
}
System.out.println(factorial);
return;
}    

public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    int n =sc.nextInt();
    calculateFactorials(n);
}


}
