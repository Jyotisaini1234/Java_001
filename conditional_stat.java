package Java_001;
import java.util.*;
public class conditional_stat {
    public static void main(String[] args){
Scanner cn =new Scanner(System.in);
 int Button = cn.nextInt();
// if (Button==1){
//     System.out.println("Hello");
// }
// else if (Button==2){
//     System.out.println("Namaste");
// }
// else if (Button==3){
//     System.out.println("Bonjour");
// }
// else{
//     System.out.println("Invalid Button");
// }

switch(Button){
    case 1:System.out.println("Hello");
    break;
    case 2:System.out.println("Namaste");
    break;
    case 3:System.out.println("Bonjour");
    break;
    default :System.out.println("Invalid Button");
}
    }
}
