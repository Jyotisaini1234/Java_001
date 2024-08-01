package Java_001;
// public class HelloWorld {
//     public static void main(String[] args) {
//         System.out.println("Hello, World! i am jyoti");
//     }
// }

// // public class Loopy {
//     public static void main (String[] args) {
//     int x = 1;
//     System.out.println("Before the Loop");
//     while (x < 4) {
//     System.out.println("in the loop");
//     System.out.println("value of x is " + x);
//     x = x + 1;
//     }
//     System.out.println("this is the after loop");
//     }}


// class IfTest {
//     public static void main (String[] args) {
//     int x = 3;
//     if (x == 3) {
//     System.out.println("x must be 3");
//     }
//     System.out.println("This runs no matter what");
//     }
//     }


// public class BeerSong {
//     public static void main (String[] args) {
//     int beerNum = 99;
//     String word = "bottles";
//     while (beerNum > 0) {
//     if (beerNum == 1) {
//     word = "bottle"; // singular, as in ONE bottle.
//     }
//     System.out.println(beerNum +""+word +"of beer on the wall");
//     System.out.println(beerNum+" "+word+"of beer");
//     System.out.println("Take one down.");
//     System.out.println("Pass it around.");
//     beerNum = beerNum - 1;
//     if (beerNum > 0) {
//     System.out.println(beerNum+" "+word+"of beer on the wall");
//     } else {
//     System.out.println("No more bottles of beer on the wall");
//     } // end else
//     } // end while loop
//     } // end main method}
// }


// public class PhraseOMatic {
//     public static void main (String[] args) {
    
//     // make three sets of words to choose from. Add your own!
//     String[] wordListOne = {"24/7","multi-Tier","30,000 foot","B-to-B","win-win","front-end",
//      "based","pervasive", "smart", "six-sigma","critical-path", "dynamic"};

//     String[] wordListTwo = {"empowered", "sticky","value-added", "oriented", "centric", "distributed",
//     "clustered", "branded","outside-the-box", "positioned",
//     "networked", "focused", "leveraged", "aligned",
//     "targeted", "shared", "cooperative", "accelerated"};
//     String[] wordListThree = {"process", "tipping-point", "solution", "architecture", "core competency",
//     "strategy", "mindshare", "portal", "space", "vision",
//     "paradigm", "mission"};
    
//     // find out how many words are in each list
//     int oneLength = wordListOne.length;
//     int twoLength = wordListTwo.length;
//     int threeLength = wordListThree.length;
    
//     // generate three random numbers
//     int rand1 = (int) (Math.random() * oneLength);
//     int rand2 = (int) (Math.random() * twoLength);
//     int rand3 = (int) (Math.random() * threeLength);
    
//     // now build a phrase
//     String phrase = wordListOne[rand1] + " " +
//     wordListTwo[rand2] + " " + wordListThree[rand3];
    
    
   
//     System.out.println("What we need is a " + phrase);
// }}




// import java.io.FileNotFoundException;

// class Dog {
//     String name;
//     int size;

//     Dog(String name, int size) {
//         this.name = name;
//         this.size = size;
//     }

//     void bark(int times) {
//         for (int i = 0; i < times; i++) {
//             System.out.println("Woof!");
//         }
//     }

//     void play() {
//         System.out.println(name + " is playing.");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         int size = 27;
//         String name = "Fido";
//         Dog myDog = new Dog(name, size);
//         int x = size - 5;
        
//         if (x < 15) {
//             myDog.bark(8);
//         }

//         while (x > 3) {
//             myDog.play();
//             x--; // Decrement x to avoid an infinite loop
//         }

//         int[] numList = {2, 4, 6, 8};
//         System.out.print("Hello ");
//         System.out.println("Dog: " + name);
//         String num = "8";
//         int z = Integer.parseInt(num);

//         try {
//             readTheFile("myFile.txt");
//         } catch (FileNotFoundException ex) {
//             System.out.println("File not found.");
//         }
//     }

//     static void readTheFile(String fileName) throws FileNotFoundException {
//         // Implement file reading logic here
//         throw new FileNotFoundException();
//     }
// }

public class Main {
    public static void main(String[] args){
        //variabels
        String name= "Jyoti";
        int a = 12;
        double price = 23.27;
        int b=22;
        name = "saini";
         
        System.out.println("This is out put "+ name +"\n "+ a +"\n "+ price+"\n"+b);
    }
}