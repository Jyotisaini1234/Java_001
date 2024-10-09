package java_array;
import java.util.*;


public class array {
public static void main(String args[]) {
    @SuppressWarnings("resource")
    Scanner sc=new  Scanner(System.in);
 int size= sc.nextInt();
 int number[]=new int[size];
//input 
for(int i=0;i<size;i++){
number[i]=sc.nextInt();
}
int x=sc.nextInt();

for(int i=0;i<number.length;i++){
    if (number[i]==x) {
        
        System.out.println("X found at index :"+i);
    }
}


    // int[] marks =new int[3];
    // int marks[]=new int[3];
    // marks[0]=97;
    // marks[1]=98;
    // marks[2]=99;
// System.out.println(marks[0]);
// System.out.println(marks[1]);
// System.out.println(marks[2]);
///output
// for(int i=0;i<size;i++){
//     System.out.println(number[i]);
// }

}
     
}