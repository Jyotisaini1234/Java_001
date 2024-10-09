public class Patterns {
 public static void main(String[] args) {
    @SuppressWarnings("unused")
    int n=4;
    // int m=5;
    /////////////////Solid Rectangle
    // for (int i=1;i<=n;i++){
    //     for(int j=1;j<=m;j++){
    //     System.out.print(" * ");

    //     }

    //     System.out.println(" * ");
    // }
    // *  *  *  *  *  * 
    // *  *  *  *  *  * 
    // *  *  *  *  *  * 
    // *  *  *  *  *  * 
/////////////////Hellow ractangle
    // for(int i=1;i<=n;i++){
    //     for(int j= 1;j<=m;j++){
    //         if(i==1 || j==1||i==n||j==m){
    //             System.out.print(" * ");
    //         }
    //         else{
    //             System.out.print("   ");
    //         }
    //     }
    //     System.out.println();
    // }
    // *  *  *  *  * 
    // *           * 
    // *           * 
    // *  *  *  *  * 
 ////////////////Half Pyramid

//  for (int i=1;i<=n;i++){
//     for(int j=1;j<i;j++){
//         System.out.print(" * ");
//     }
//     System.out.println();
//  }
//  * 
//  *  * 
//  *  *  * 

//////////////////inverted the  half pyramid
// for (int i=n;i>=1;i--){
//     for(int j=1;j<=i;j++){
//         System.out.print(" * ");
//     }
//     System.out.println();
// } 
// *  *  *  * 
// *  *  * 
// *  * 
// *
///////nverted the  half pyramid (rotated by 180deg)
// for (int i= 1;i<=n;i++){
//   for(int j=1;j<=n-i;j++){
//     System.out.print(" ");
//   }
//    for(int j=1;j<=i;j++){
//     System.out.print("*");
// }
// System.out.println();

// }
// *
// **
// ***
// ****

/////half pyramid with number

// for (int i=1;i<=n;i++){
//     for(int j=1;j<=i;j++){
//         System.out.print(j);
//     }
//     System.out.println();
// }
// 1
// 12
// 123
// 1234
//////// inverted half pyramid with number

// for (int i=1;i<=n;i++){
//         for(int j=1;j<=n-i;j++){
//             System.out.print(j);
//         }
//         System.out.println();
//     }
//     123
//     12
//     1

////////////Flyod's Triangle

// int Number= 1;
// for (int i=1;i<=n;i++){
//     for(int j=1;j<=i;j++){
//         System.out.print(Number+" ");
//         Number++;
//     }
//     System.out.println();
// }
// 1 
// 2 3 
// 4 5 6 
// 7 8 9 10 

//////////////0-1 Triangle

// for(int i=1;i<=n;i++){
//     for(int j=1;j<=i;j++){
//         int sum =i+j;
//         if(sum%2==0){
//             System.out.print("1");
//         }else{
//             System.out.print("0");
//         }
//     }
//     System.out.println();
// }
// 1
// 01
// 101
// 0101


////////////////butterfly pattern 
// for (int i= 1;i<=n;i++){
//       for(int j=1;j<=i;j++){
//         System.out.print("*");
//       }
//       //space
//       int space=2*(n-i);
//       for(int j=1;j<=space;j++){
//         System.out.print(" ");
//       }
//       //2nd 
//       for(int j=1;j<=i;j++){
//         System.out.print("*");
//       }
//       System.out.println();
//     }
//     //lower half
//     for (int i=n;i>=1;i--){
//         for(int j=1;j<=i;j++){
//           System.out.print("*");
//         }
//         //space
//         int space=2*(n-i);
//         for(int j=1;j<=space;j++){
//           System.out.print(" ");
//         }
//          //2nd 
//       for(int j=1;j<=i;j++){
//         System.out.print("*");
//       }
//         System.out.println();
//       }
// *      *
// **    **
// ***  ***
// ********
// ********
// ***  ***
// **    **
// *      *

    
// /////////////solid rombus
// int num=5;
// for(int i =1;i<=num;i++){
//     ////space
//     for(int j=1;j<=num-i;j++){
//         System.out.print(" ");
//     }
//     ////starts 
//     for(int j=1; j<=5;j++){
//         System.out.print("*");
//     }
//     System.out.println();
// }
//     *****
//    *****
//   *****
//  *****
// *****
///////Number pyramid
// for (int i =1;i<=n;i++){
//     ///////space
//     for(int j=1;j<=n-i;j++){
//         System.out.print(" ");
//     }
// ///number====print  row no ,row no time
// for(int j=1;j<=i;j++){
//     System.out.print(i + " ");
// }
// System.out.println();

// }
// 1 
// 2 2 
// 3 3 3 
// 4 4 4 4


// for(int i=1;i<=n;i++){
//     //space
//     for(int j=1;j<=n-i;j++){
//         System.out.print(" ");
//     }
//     ///1st half number
//     for(int j=i;j>=1;j--){
//         System.out.print(j);
//     }
//      ///2st half number
//      for(int j=2;j<=i;j++){
//         System.out.print(j);
//     }
//     System.err.println();
// }
//    1
//   212
//  32123
// 4321234

////////////Diamond  pattern
// for (int i=1;i<=n;i++){
//     for(int j=1;j<=n-i;j++){
//         System.out.print("  ");
//     }
//     //stars
//     for(int j=1;j<=2*i;j++){
//         System.out.print(" *");
//     }
//     System.out.println();
// }
// //////lowerhalf
// for (int i=n;i>=1;i--){
//     for(int j=1;j<=n-i;j++){
//         System.out.print("  ");
//     }
//     //stars
//     for(int j=1;j<=2*i-1;j++){
//         System.out.print(" *");
//     }
//     System.out.println();
// }
//         *
//        * *
//      * * * *
//    * * * * * *
//  * * * * * * * *
//  * * * * * * *
//    * * * * *
//      * * *
//        *
    }
        

}
