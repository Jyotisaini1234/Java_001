package Java_001;
///////////run this code using (javac Main1.java,java Main1)

public class Main1 {

    // Define the Animal class
    static abstract class Animal {
        String name;
        int age;
        double weight;
        double height;

        void eat() {
            System.out.println(name + " is eating");
        }

        void sleep() {
            System.out.println(name + " is sleeping");
        }

        void move() {
            System.out.println(name + " is moving");
        }

        abstract void makeSound();
    }

    // Define the Mammal class
    static abstract class Mammal extends Animal {
        void nurse() {
            System.out.println(name + " is nursing its young");
        }
    }

    // Define the Dog class
    static class Dog extends Mammal {
        @Override
        void makeSound() {
            System.out.println(name + " is barking");
        }

        void wagTail() {
            System.out.println(name + " is wagging its tail");
        }
    }

    // Define the Cat class
    static class Cat extends Mammal {
        @Override
        void makeSound() {
            System.out.println(name + " is meowing");
        }

        void purr() {
            System.out.println(name + " is purring");
        }
    }

    // Define the Bird class
    static abstract class Bird extends Animal {
        void fly() {
            System.out.println(name + " is flying");
        }
    }

    // Define the Eagle class
    static class Eagle extends Bird {
        @Override
        void makeSound() {
            System.out.println(name + " is screeching");
        }

        void soar() {
            System.out.println(name + " is soaring high");
        }
    }

    // Define the Fish class
    static abstract class Fish extends Animal {
        void swim() {
            System.out.println(name + " is swimming");
        }
    }

    // Define the Shark class
    static class Shark extends Fish {
        @Override
        void makeSound() {
            System.out.println(name + " is making a sound (though sharks don't typically make sounds)");
        }

        void hunt() {
            System.out.println(name + " is hunting");
        }
    }

    // Define the Reptile class
    static abstract class Reptile extends Animal {
        void crawl() {
            System.out.println(name + " is crawling");
        }
    }

    // Define the Snake class
    static class Snake extends Reptile {
        @Override
        void makeSound() {
            System.out.println(name + " is hissing");
        }

        void slither() {
            System.out.println(name + " is slithering");
        }
    }

    // Main method
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Buddy";
        dog.eat();
        dog.makeSound();
        dog.wagTail();

        Cat cat = new Cat();
        cat.name = "Whiskers";
        cat.eat();
        cat.makeSound();
        cat.purr();

        Eagle eagle = new Eagle();
        eagle.name = "Eagle";
        eagle.eat();
        eagle.makeSound();
        eagle.soar();

        Shark shark = new Shark();
        shark.name = "Great White";
        shark.eat();
        shark.makeSound();
        shark.hunt();

        Snake snake = new Snake();
        snake.name = "Slither";
        snake.eat();
        snake.makeSound();
        snake.slither();
    }
}
