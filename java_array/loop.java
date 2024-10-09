import java.util.Scanner;

public class loop {
    public static void main(String[] args){
    //     for(int count=0; count <3;count=count+1){
    //     System.out.println("Hello world");
    // }
    // for(int i=0; i <11;i++){
    //     System.out.println("Hello world");
    // }

// int i =0;
// while (i<12){
//     System.out.println(i);
//     i=i+1;
// }

// int j=0;
// do{
//     System.out.println(j);
//     j=j+1;
// }while(j<100);
// }
@SuppressWarnings("resource")
Scanner sc=new Scanner(System.in);

int n= sc.nextInt();
// int sum=0;
// for (int i=0;i<=n;i++){
//     sum=sum+i;
// }
// System.out.println("The value of sum is "+sum);

for(int i=1;i<11;i++){
    
    System.out.println(i*n);
}

}
}